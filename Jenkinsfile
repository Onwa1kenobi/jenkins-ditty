pipeline {
    agent any
    environment {
        GOOGLE_APPLICATION_CREDENTIALS="$HOME/app/jenkins-demo-1e5fd-firebase-adminsdk-poub4-eae87f326c.json"
    }
    
    stages {
        stage('Build') {
            steps {
                echo 'Build Android project using Gradle'
                sh './gradlew clean assembleDebug'
                // Archive the APKs so that they can be downloaded from Jenkins
                archiveArtifacts artifacts: '**/*.apk', fingerprint: false, allowEmptyArchive: false
            }
        }
        
        stage('Unit and Integration Tests') {
            steps {
                echo 'Run unit tests for Android project with JUnit'
                sh './gradlew app:test'
                
                echo 'Run integration tests (e.g., UI tests using Espresso)'
                // Implement integration test commands here
            }
        }
        
//         stage('Code Analysis') {
//             environment {
//                 scannerHome = tool 'Sonar'
//             }
//             steps {
//                 script {
//                     withSonarQubeEnv('Sonar') {
//                         sh "${scannerHome}/bin/sonar-scanner \
//                             -Dsonar.projectKey=Demo-Application \
//                             -Dsonar.projectName='Demo Application' \
//                             -Dsonar.projectVersion=1.0 \
//                             -Dsonar.sources=."
//                     }
//                 }
//             }
//         }
        
        stage('Security Scan') {
            steps {
                echo 'Perform security scan using a tool like OWASP Dependency-Check'
                // Implement security scan commands here
            }

//             post {
//                 success {
//                     echo 'Security Scan completed successfully'
//                     emailext(
//                         to: 'amehugochukwu@gmail.com',
//                         subject:"The status of the Security Scan: ${currentBuild.result}",
//                         body:'Log files are attached for additional information about the process',
//                         attachLog: true
//                     )
//                 }
//                 failure {
//                     echo 'Security Scan failed'
//                     emailext(
//                         to: 'amehugochukwu@gmail.com',
//                         subject:"The status of the Security Scan: ${currentBuild.result}",
//                         body:'Log files are attached for additional information about the process',
//                         attachLog: true
//                     )
//                 }
//             }
        }
        
        stage('Deploy to Staging') {
            steps {
                echo 'Deploy the Android application to a staging server (e.g., Firebase App Distribution)'
                steps {
                    archiveArtifacts artifacts: 'app/build/outputs/apk/release/*.apk', fingerprint: false, allowEmptyArchive: false
                    withEnv(environment) {
                        sh './gradlew assembleRelease appDistributionUploadRelease'
                    }
                }
            }
        }
        
        stage('Integration Tests on Staging') {
            steps {
                echo 'Run integration tests on the staging environment'
                // Implement staging integration test commands here
            }
        }
        
        stage('Deploy to Production') {
            steps {
                echo 'Deploy the Android application to a production server (e.g., Firebase App Distribution)'
                archiveArtifacts artifacts: 'app/build/outputs/apk/release/*.apk', fingerprint: false, allowEmptyArchive: false
                withEnv(environment) {
                    sh './gradlew assembleRelease appDistributionUploadRelease'
                }
            }
        }
    }
}
