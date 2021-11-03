pipeline{

    agent any   

    
    stages{
        
        stage('Maven Clean Compile'){
            steps {
                echo "starting maven"
                echo "Initiating clean compile commands"
                sh 'mvn --version'
                sh 'mvn clean compile install'
                
            }
            
        }
        stage('Maven Test'){
            steps {
                echo "Initiating Dynamic test ! "
                sh 'mvn test'
            }
        }
        stage('Maven install'){
            steps {
                echo "Installing the app "
                sh 'mvn install'
            }
        }
        
              
        //stage('Remove')
        stage('Notification!'){
            steps {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "atef.hafdhi@esprit.tn", 
                    subject: 'New build Alert !: $PROJECT_NAME - #$BUILD_NUMBER'
      
            }
            
        }
        
    }
    
}