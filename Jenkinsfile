pipeline {

    agent any
    tools {
        maven 'Maven' 
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }
	stage("build & SonarQube analysis-----") {
            steps {
              withSonarQubeEnv('Sonar') {
                bat 'mvn clean package sonar:sonar'
              }
            }
			}

         stage('testing stage') {
             steps {
                bat "mvn test"
                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
        }
    }

          stage('Install stage') {
              steps {
                bat "mvn install"
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
        }
    }
	


  }
 
}