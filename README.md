# AD CAMPAIGN RESTFUL SERVICE

This application is developed using Spring boot and H2 database as embedded or in-memory database. Gradle has been used as build and dependency management tool.

## How to run this Spring boot application

Make sure you have latest version of Gradle installed and PATH is configured.
Go to the directory where you unzipped the file i.e. where the build.gradle is there
or
* Clone this repository
Run gradle clean bootRun command
This should run the application and once the application runs you should see something like this
```
2017-08-06 13:07:10.666  INFO 9656 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2017-08-06 13:07:10.671  INFO 9656 --- [  restartedMain] c.c.xh.AdCampaignServiceApplication      : Started AdCampaignServiceApplication in 5.258 seconds (JVM running for 5.75)
```

## About the Service

You can call some REST endpoints defined in ```com.comcast.xh.controller.AdCampaignController``` on **port 8090**.
You can call some of the operational endpoints like
```
http://localhost:8090/campaign/addCampaign
```

Here are some endpoints you can call:

### Create a Campaign for a Partner

```
POST http://localhost:8090/campaign/addCampaign
Accept: application/json
Content-Type: application/json

{

"partnerid": "Comcast",
"duration":10,
"adcontent":"XH Advertising",
"adtitle":"XH Home Security",
"adstatus":"Active"

}

RESPONSE: HTTP 200 (Created)
```
### Retrieve all Campaigns

```
GET http://localhost:8090/campaign/getAllCampaigns

Response: HTTP 200
Content: List of all Campaigns
```

### Update a Campaign

```
PUT http://localhost:8090/campaign/updateCampaign
Accept: application/json
Content-Type: application/json

{

"partnerid": "Comcast",
"duration":100,
"adcontent":"XH Advertising",
"adtitle":"XH Home Security",
"adstatus":"Active"

}

RESPONSE: HTTP 200
```

### Retrieve Camapign based on partnerid

```
GET http://localhost:8090/campaign/getCampaign/{partnerid}

Response: HTTP 200
Content: Campaign in json format
```
### Retrieve Camapign by adcontent

```
GET http://localhost:8090/campaign/getCampaignsByAdContent/{adcontent}

Response: HTTP 200
Content: Array of Campaigns in json format
```

### Retrieve Camapign by adtitle

```
GET http://localhost:8090/campaign/getCampaignsByAdTitle/{adtitle}

Response: HTTP 200
Content: Array of Campaigns in json format
```