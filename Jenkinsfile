pipeline {
  agent {
    dockerfile {
      filename 'walle'
    }

  }
  stages {
    stage('package') {
      steps {
        sh 'mvn clean install package \'-Dmaven.test.skip=true\''
      }
    }

  }
  environment {
    EXPOSE = '8081'
  }
}