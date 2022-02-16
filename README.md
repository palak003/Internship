# Internship
I have added a relation of groups with the users too using one to many bidirectional relation

I have also added swaager ui which can be viewed on localhost:8080/swagger-ui.html 


FOR USERS:


Add a user:
endpoint: /api/createUser
[testcase]: RequestBody
{
"name":"Palak",
"emailId":"palak2010203@akgec.ac.in",
"mobileNumber":"8448047067"
}
Response 200 Ok 
or else
{"User already exists by this email id","enter valid email id",
"enter valid phone number"}

Update a user:
endpoint: /api/updateUser
[testcase]: RequestBody
{
"name":"Palak",
"emailId":"palak2010203@akgec.ac.in",
"mobileNumber":"8448047067"
}
RequestParam : {updateId :1}
Response 200 ok
or else
{"No such user exists","enter valid email id",
"enter valid phone number"}

Delete a user:
endpoint: /api/deleteUser
[testcase]: RequestParam {id : 1}
Response 200 Ok
or else
{"No such user exists"}


Get a user:
endpoint: /api/getUser
[testcase]: RequestParam {id :1}
Response 200 Ok
or else
{"No such user exists"}

Get all users:
endpoint: /api/getAllUsers
Response 200 Ok


FOR GROUPS:
Add group:
endpoint: /api/addGroup
[testcase]: RequestBody
{
"groupName":"gp2",
"groupStrength":20,
"userId":1
}
Response 200 ok
or else
{"No such user exists"}

Update group:
endpoint: /api/updateGroup
[testcase]:RequestBody
{
"groupName":"gp2",
"groupStrength":20,
"userId":1
}
RequestParam: {groupId :1}
response 200 ok
or else
{"No such group exists", No such user exists"}

Get all groups of user:
endpoint: /api/getAllGroupsOfUser
[testcase]:  requestParam : {userId :1}
response 200 ok
or else
{"No such user exists"}

Delete a group:
endpoint: /api/deleteGroup
[testcase]: requestParam: {groupId :1}
response 200 ok
or else
{"No such group exists"}

