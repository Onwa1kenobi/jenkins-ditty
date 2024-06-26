pipeline {
    agent any
    environment {
        GOOGLE_APPLICATION_CREDENTIALS = credentials('jenkins-google-credentials')
        GOOGLE_PROJECT_ID = 'jenkins-demo-1e5fd'
    }
    
    stages {
        stage('Setup') {
            steps {
                echo 'Copy necessary files'
                fileOperations([
                    fileCreateOperation(
                        fileName: "GOOGLE_APPLICATION_CREDENTIALS.json",
                        fileContent: '${GOOGLE_APPLICATION_CREDENTIALS}'
                    )
                ])
            }
        }
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

        stage('Authorize gcloud') {
            steps {
                echo 'Authorize gcloud and set config defaults'
                sh '${GCLOUD_PATH}/gcloud auth activate-service-account --key-file=GOOGLE_APPLICATION_CREDENTIALS.json'
                sh '${GCLOUD_PATH}/gcloud --quiet config set project ${GOOGLE_PROJECT_ID}'
            }
        }

        stage('UI Instrumentation Tests with Espresso on Firebase Test Lab') {
            steps {
                echo 'Run UI tests using Espresso with Firebase Test Lab'
                sh './gradlew connectedAndroidTest'
                sh '''
                    ${GCLOUD_PATH}/gcloud firebase test android run \
                    --type instrumentation \
                    --device model=Pixel3,orientation=portrait,locale=en,version=30 \
                    --app ./app/build/outputs/apk/debug/app-debug.apk \
                    --test ./app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
                '''
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
                    archiveArtifacts artifacts: '**/*.xml', allowEmptyArchive: true
                }
                success {
                    echo 'UI tests passed'
                }
                failure {
                    echo 'UI tests failed'
                }
            }
        }

        stage('Code Analysis') {
            environment {
                scannerHome = tool 'Sonar'
            }
            steps {
                script {
                    withSonarQubeEnv('Sonar') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=jenkins-demo \
                            -Dsonar.projectName='Demo Application' \
                            -Dsonar.projectVersion=${BUILD_NUMBER} \
                            -Dsonar.sources=."
                    }
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
