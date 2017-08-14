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
http://localhost:8090/adcampaign/campaign
```

Here are some endpoints you can call:

### Create a Campaign for a Partner

```
POST http://localhost:8090/adcampaign/campaign
Accept: application/json
Content-Type: application/json

{

"partnerid": "Comcast",
"duration":10,
"adcontent":"XH Advertising",
"adtitle":"XH Home Security",
"adstatus":"Active"

}

RESPONSE: HTTP 201 (Created)
```
### Retrieve all Campaigns

```
GET http://localhost:8090/adcampaign/campaign

Response: HTTP 200
Content: Array of all Campaigns
```

### Update a Campaign

```
PUT http://localhost:8090/adcampaign/campaign
Accept: application/json
Content-Type: application/json

{
"campaignid":10,
"partnerid": "Comcast",
"duration":100,
"adcontent":"XH Advertising",
"adtitle":"XH Home Security",
"adstatus":"Active"

}

RESPONSE: HTTP 200
```

### Retrieve Camapaign based on campaignid

Returns the campaign only if its active and created tim + duration < current time
```
GET http://localhost:8090/adcampaign/campaign/{campaignid}

Response: HTTP 200
Content: Campaign in json format
```
### Retrieve all active Camapaign's based on partnerid

Returns the campaign only if its active and created tim + duration < current time
```
GET http://localhost:8090/adcampaign?partnerid={partnerid}

Response: HTTP 200
Content: Array of Campaign's in json format
```
### Retrieve Camapign by adcontent

```
GET http://localhost:8090/adcampaign/campaign?adcontent={adcontent}

Response: HTTP 200
Content: Array of Campaigns in json format
```

### Retrieve Camapign by adtitle

```
GET http://localhost:8090/adcampaign/campaign?adtitle={adtitle}

Response: HTTP 200
Content: Array of Campaigns in json format
```

### Delete Camapign

```
DELETE http://localhost:8090/adcampaign/campaign/{campaignid}

Response: HTTP 200

```

### Retrieve Camapign by adtitle and duration

```
GET http://localhost:8090/adcampaign/campaign?duration={duration}&adtitle={adtitle}
Ex: http://localhost:8090/adcampaign/campaign?duration=400&adtitle=XH Home Security

Response: HTTP 200
Content: Campaign in json format
```