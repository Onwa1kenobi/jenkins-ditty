pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Build Android project using Gradle'
                // sh './gradlew clean assembleDebug'
            }
        }
        
        stage('Unit and Integration Tests') {
            steps {
                echo 'Run unit tests for Android project with JUnit'
                sh './gradlew testDebugUnitTest'
                
                echo 'Run integration tests (e.g., UI tests using Espresso)'
                // Implement integration test commands here
            }
        }
        
        stage('Code Analysis') {
            steps {
                echo 'Integrate code analysis tool (e.g., SonarQube)'
                // Implement code analysis commands here
            }
        }
        
        stage('Security Scan') {
            steps {
                echo 'Perform security scan using a tool like OWASP Dependency-Check'
                // Implement security scan commands here
            }
        }
        
        stage('Deploy to Staging') {
            steps {
                echo 'Deploy the Android application to a staging server (e.g., Firebase App Distribution)'
                // Implement deployment commands here
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
                // Implement production deployment commands here
            }
        }
    }
    
    post {
        success {
            // Send notification email on successful pipeline execution
            emailext subject: 'Pipeline Success',
                      body: 'Pipeline completed successfully.',
                      to: 'amehugochukwu@gmail.com',
                      attachmentsPattern: '**/*'
        }
        failure {
            // Send notification email on failed pipeline execution
            emailext subject: 'Pipeline Failure',
                      body: 'Pipeline failed to execute.',
                      to: 'amehugochukwu@gmail.com',
                      attachmentsPattern: '**/*'
        }
    }
}
