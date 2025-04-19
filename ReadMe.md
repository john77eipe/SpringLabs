# SpringLabs

The following is a developers journey as well as a demonstration of what's possible with Spring.

### How is it different from PetClinic ?

This is similar to PetClinic in some ways but it is going to be a lot more.

What is PetClinic for those who haven't heard about PetClinic? 

The Spring PetClinic is a sample application designed to show how the Spring stack can be used to build simple, but powerful database-oriented applications.

Have a look here: https://spring-petclinic.github.io/

### What is SpringLabs about?

SpringLabs will encompass a lot more and one of them is developing a Spring application based on a fictional usecase. This will sound a lot similar to PetClinic but 

- we will be covering the whole process and software development cycle like a real-time project. 
- we will have project delivery phases and each phase will have multiple sprints.  
- expanding more on the usecases and integrations 
- journal the development process - essentially the challenges and observations to benefit other developers

We will start with a **simple pizza store usecase** for demonstration.

This will stand out as a reference implementation using the latest spring stack and also as a tutorial for anyone who wants to learn Spring.


### Primary technology stack and build tools

I'm using Spring version 5. 

There are 4 choices  

- `spring-boot-maven`: for a maven spring boot configuration
- `spring-bom-maven`: for a standard spring maven configuration running on server's like wildfly.
- `spring-boot-gradle`: for a gradle spring boot configuration
- `spring-bom-gradle`: for a standard spring gradle configuration running on server's like wildfly.

We will start by using `spring-boot-maven`.

### Code management

We will develop the application in phases. If you like to view the latest version go to the **main** branch.

You will also notice that sprint will have it's own branch with names like `s1-<optional feature detail>-spring-boot-maven`. 
This is for posterity and learning.


# PizzaStore Project

We will develop a pizza store web application in multiple phases. Each phase will be spread out in multiple sprints and as stated above each sprint will be published in each branch.

The use case is simple.

> A fictional store owner needs a online e-commerce store for his pizza outlet. Customers should be able to view different pizzas available and then order them for pickup. 

Each Phase of the project, its details like scope and the individual sprints are tracked in seperate files.

All the files follow a similar structure. It first outlines the scope of the Phase and the deliverables of the project. Then it moves on to different sprints.
Each sprint will have it's objectives, link to the source code, notes and challenges faced during development.

- [Phase 1](Phase1.md) - The very first phase of the project. We build a MVP (minimum viable product) through this phase.
