
# Steps for implementing the Camel asynchronous routing and Kafka integration PoC

## Pre-requisites
1. You have access to the OCP cluster.
2. You have a workstation where you can download and run software from internet
3. You have JRE installed on the workstation.
4. You have Postman tool to execute the REST APIs.

## PoC Objective
- To demonstrate the wiretap component of Camel for implementing “fire-and-forget” style process execution.
- To demonstrate integration of Camel with Kafka via camel-kafka component.

## PoC Methodology
- This PoC will deploy a simple web service which accepts an XML input for creating an employee object. It triggers the employee creation internal API, but generates an
acknowledgement number and returns acknowledgement to the consumer immediately without waiting for the internal process to complete.
- We utilize a dummy REST api, accessible over internet (https://dummy.restapiexample.com/) as the backend for creating the employee resource.
- The response from the backend (dummy) service is displayed in terminal logs, as the response to the original service is already sent to consumer.
- We additionally enrich this response with the generated acknowledgement number and produce it to a topic named “requests” in the Kafka broker.
- We browse the Kafka broker topic to confirm that the message was indeed produced in the topic with the response from the backend service and the acknowledgement
 number.
 
## Implementation Steps
1. Create a project in OCP and deploy the Camel code on OCP using S2I. On your OCP project, in developer mode, Click the +Add and then select “Import from Git”. Provide the Git Repo URL as
https://github.com/summu1985/liberty-poc.git. Click on “Show advanced git options” and in the “Context dir” textbox, enter
“/async-routing”. Change the name of the project, if needed. Leave the rest as default and click the “Create” button. Your service should be deployed.
2. Once deployment is successful, access the Topology option from the Developer view and retrieve the publicly accessible URL of the deployed Camel REST service as shown below from the section called Route.
3. To actually access the webservice, append the ‘/camel/asyncrouting at the end of the URL shown in route. Provide input data to the service in JSON to receive the acknowledgement.
The input can be provided as below XML data :
```<employee>
<firstname>firstname</firstname>
<lastname>lastname</lastname>
<salary>1000</salary>
<age>37</age>
</employee>
```
4. Expected response from the service is as follow :
> Employee Creation request acknowledged. Reference number : XXYY-XXYY-XXYY-XXYY-XXYYZZYY

Actual screenshot of the invocation from Postman is below.

<img width="828" alt="Screenshot 2023-01-19 at 1 09 00 AM" src="https://user-images.githubusercontent.com/69989028/213628401-74fce329-d79a-42f1-ac3c-5c59f91202c7.png">

Logs from the deployed application is below :

<img width="1329" alt="Screenshot 2023-01-19 at 1 11 43 AM" src="https://user-images.githubusercontent.com/69989028/213628792-033319ee-2607-4850-b99e-175f34fe928a.png">

5. In order to browse the Kafka topics, a tool called Kafdrop will be used. Follow the steps here : https://github.com/summu1985/debezium-cdc-demo/blob/main/Kafdrop%20steps.txt to install it on your OCP cluster. Access the kafdrop UI and click on the name of the topic at the bottom left and then click on partition 0 to browse
messages in the topic.

<img width="1120" alt="Screenshot 2023-01-19 at 1 15 12 AM" src="https://user-images.githubusercontent.com/69989028/213629040-0e397392-e6f9-4316-bae3-df033d34203c.png">

Click on the name of the topic at the bottom left and then click on partition 0 to browse messages in the topic.

<img width="1120" alt="Screenshot 2023-01-19 at 1 16 37 AM" src="https://user-images.githubusercontent.com/69989028/213629112-0fd7a528-5b29-4a5a-8eea-f4f04e853366.png">
