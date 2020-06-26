node {

    stages {
        stage('Compile stage') {
   
            steps {
            	def mvnHome = tool name: 'Maven', type: 'maven'
                sh "${mvnHome}/bin/mvn package" 
        }
    }
	stage("build & SonarQube analysis-----") {
            steps {
              withSonarQubeEnv('Sonar') {
                sh 'mvn clean package sonar:sonar'
              }
            }
			}

         stage('testing stage') {
             steps {
                sh "mvn test"
                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
        }
    }

          stage('Install stage') {
              steps {
                sh "mvn install"
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
        }
    }
	


  }
 
}