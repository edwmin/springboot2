pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 1.8.0_221'
    }
    stages {
        stage('Build') {
            steps {
                
                
                sh 'mvn -f JobPost/pom.xml -B -DskipTests clean package'
            }
        }
    }
}
