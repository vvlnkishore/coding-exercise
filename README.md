# coding-exercise

The Coding exercise consists of 3 endpoints as given below

http://localhost:8080/rewards/retrieve-points

This enpoint is used to fetch all the customers rewards data in a monthly basis
Method: HTTP GET

http://localhost:8080/rewards/retrieve-points/{customerId}

This enpoint is used to fetch single customer rewards data in a monthly basis. We have to add customerId in the URL path
Method: HTTP GET

http://localhost:8080/rewards/add-points

This enpoint is used to to calculate and store reward points in the database of a customer's transaction
Method: HTTP POST
The example payload used to invoke this endpoint is as given below.
{
	"customerId":1,
	"customerName":"Kishore",
	"transactionAmount":250
}
