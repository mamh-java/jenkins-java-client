
mvn deploy:deploy-file -DgroupId=com.mage.jenkins -DartifactId=jenkins-java-client \
    -Dversion=1.1 -Dpackaging=jar -Dfile=$PWD/target/jenkins-java-client-1.1.jar \
    -Durl=http://maven.mage.com/content/repositories/thirdparty/ \
    -DrepositoryId=thirdparty
