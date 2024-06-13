pipeline{
    agent any
    
    stages{
        stage("Build and test"){
            steps{
                bat "mvn clean test -PPet"
            }
            post{
                success{allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])
            
                }
            }
            
        }
    }
}
