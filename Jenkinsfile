pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                bat 'mvn --version'
                sh 'Welcome to Jenkin by Rajesh sh'
                bat 'Welcome to Jenkin by Rajesh bat'
            }
        }
    }
}
