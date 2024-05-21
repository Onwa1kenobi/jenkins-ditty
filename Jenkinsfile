pipeline {
    agent any
    environment {
        GOOGLE_APPLICATION_CREDENTIALS = credentials('jenkins-google-credentials')
    }
    
    stages {
        stage('Build') {
            steps {
                echo 'Build Android project using Gradle'
                sh './gradlew clean assembleDebug'
                archiveArtifacts artifacts: '**/*.apk', fingerprint: false, allowEmptyArchive: false
            }
        }
        
        stage('Unit Tests') {
            steps {
                echo 'Run unit tests for Android project with JUnit'
                sh './gradlew app:test'
            }
        }

        stage('UI Tests with Espresso') {
            steps {
                echo 'Run UI tests using Espresso'
                sh './gradlew connectedAndroidTest'
            }
            post {
                always {
                    junit '**/build/test-results/connected/*.xml'
                    archiveArtifacts artifacts: '**/build/outputs/reports/androidTests/connected/*', allowEmptyArchive: true
                }
                success {
                    echo 'UI tests passed'
                }
                failure {
                    echo 'UI tests failed'
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploy the Android application to a staging server (e.g., Firebase App Distribution)'
                sh './gradlew assembleRelease'
                archiveArtifacts artifacts: 'app/build/outputs/apk/release/*.apk', fingerprint: false, allowEmptyArchive: false
                sh './gradlew assembleRelease appDistributionUploadRelease'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploy the Android application to a production server (e.g., Firebase App Distribution)'
                archiveArtifacts artifacts: 'app/build/outputs/apk/release/*.apk', fingerprint: false, allowEmptyArchive: false
                sh './gradlew assembleRelease appDistributionUploadRelease'
            }
        }
    }
}
