pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Build World'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy World'
            }
        }
        stage('Test') {
            steps {
                echo 'Test World'
            }
        }
    }
    post {
        always {
            emailext (
                subject: "Pipeline Result: ${currentBuild.currentResult}",
                body: "Build status: ${currentBuild.currentResult}\nSee console: ${env.BUILD_URL}",
                to: "ishagupta2719@gmail.com",
                replyTo: "ishagupta2719@gmail.com",
                mimeType: 'text/plain'
            )
        }
    }
}
