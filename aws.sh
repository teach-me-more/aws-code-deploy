aws ec2 create-security-group
--description "This security group allow access to instance for ssh"
--group-name "${JOB_NAME}-security-group"


org-template

$ aws cloudformation create-stack --stack-name JenkinsToAWSDeploy --template-url https://s3-us-west-2.amazonaws.com/cloudformation-templates-us-west-2/EIP_With_Association.template --parameters ParameterKey=InstanceType,ParameterValue=t2.micro ParameterKey=KeyName,ParameterValue=fromJenkinstoAWS ParameterKey=SSHLocation,ParameterValue=$(curl -s ifconfig.io)/32
