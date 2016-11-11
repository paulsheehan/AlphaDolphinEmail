# AlphaDolphinEmail
Source code for the web-based email client that the Alpha Dolphins created as part of their Team Projects assignment of 3rd year.

The UML class diagram below illustrates how a servlet was used to handle HTTP requests from user clicks then after a serious of class to class communication using methods, a webpage is returned to the client in forwardToPage(). A command factory is used to handle the large possibility of commands from sending the email and loading the inbox, to logging in and registering a new account. The command factory was implemented as a singleton.

The POJO classes are connected to a mySQL database in which XAMPP was used to host locally.

![classdiagram1](https://cloud.githubusercontent.com/assets/6611206/20199263/35bdc2dc-a7a1-11e6-8d18-b5cd6a757aa1.jpg)

Below is a UML sequence diagram which demonstrates how these classes communicate with each other with methods. It shows how the login use case is handled. I am aware the sequence diagram is not perfect but it gets the message accross about how a general use case is handled on our system.

![loginsequence](https://cloud.githubusercontent.com/assets/6611206/20199611/9b8e5a02-a7a3-11e6-9e60-8bcabd8df6ba.jpg)
