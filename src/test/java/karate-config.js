function () {

   ///// ENVIRONMENTS
   var  sampleApiAWS = 'UNDEFINED'
   var sampleApiLocal = 'http://localhost:3000/api/products'

   ///// DEFAULT ENVIRONMENT
   var env = 'local';
   karate.log('Selected environment is: ', env);

   ///// ENVIRONMENT CONFIGURATION
   var aws = {
              name: 'aws',
              description: 'APIs running in AWS lambda functions',
              baseURL: sampleApiAWS,
              username: 'Ronaldo',
              password: 'P@ssword001'
   }

   var local = {
                 name: 'local',
                 description: 'APIs running on local',
                 baseURL: sampleApiLocal,
                 username: 'Ronaldo',
                 password: 'P@ssword001'
      }

   if (env == 'aws'){
       var testConfig = {
           baseAPIUrl: aws.baseURL,
           apiUsername: aws.username,
           apiPassword: aws.password
       }
   }

   else{
       var testConfig = {
           baseAPIUrl: local.baseURL,
           apiUsername: local.username,
           apiPassword: local.password
       }
   }

     //karate.configure('connectTimeout', 25000);
     //karate.configure('readTimeout', 25000);

   return testConfig;
}