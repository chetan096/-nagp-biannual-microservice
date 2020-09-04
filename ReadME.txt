Ride Service: 
  1. Request Ride 
  2. Book Ride
  3. After Book it will call user service to send notification
  4. Call Driver service to get details of available driver.
  
Driver Service: 
  1. You can update trip status.
  2. You can book a driver for a trip which match the availabilty.
  
Notification:
  1. Send notification to user
  2. We can also make it async. by publishing message to queue and on the basis of email , it will trigger email.
  
  
Do pass token "12345" for the security through api gateway.

Swagger enabled to hit api.


Kubernetes:

1. Expose Ride service to the internet using load balancer.
2. All communication will happen through that only.
3. Driver Service and Notification service will be deployed using ClusterIp type of service, no internet access.
4. Ride needs persiteence to keep the booked ride.
5. Driver needs peristence to keep updated about the drivers information.
6. Notification don't need any persistence in stead of templates for email. 


github link: https://github.com/chetan096/nagp-biannual-microservice