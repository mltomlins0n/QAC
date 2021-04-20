# Pega Decisioning Notes

## Contents

* [Objectives](#obj)
* [Next-Best-Action (NBA)](#NBA)
* [NBA Designer](#NBADesign)
* [Propositions](#prop)
  * [Dynamic Pricing](#pricing)
  * [Prioritization](#priority)
  * [Target Audience](#audience)
  * [Eligibility Criteria](#eligible)
* [Data Analytics](#data)
  * [Predictive](#predict)
  * [Adaptive](#adapt)
  * [Predictive vs Adaptive](#predictVSadapt)
* [Interaction History](#history)
* [Decisioning Simulations](#sim)
* [Arbitrating between Propositions](#arbitrate)
* [Evaluating Customer Credit Score](#credit)
  * [Decision Tables](#decisionTable)
* [Product Holdings](#holdings)
* [3rd Party Predictive Models](#3rdParty)
* [Adaptive Analytics](#adaptive)
  * [Adaptive Modelling Cycle](#adaptiveModel)
* [Text Analytics](#text)
  * [Email Routing](#email)

___

<a name="obj"></a>
## Objectives

* Understand the basic components and capabilities of the Pega Customer Decision Hub.

* Understand how Next-Best-Action improves the customer experience.

* Configure Next-Best-Action designer to automate Next-Best-Action strategy design process.

* Explain how predictive and adaptive modeling works and use them in decision strategies.

* Prioritize propositions based on predicted customer behaviour.

* Run alternative strategies and compare the results using Visual Business Director.

___

<a name="NBA"></a>
## Next-Best-Action (NBA)

**The Customer Decision Hub combines analytics, business rules, customer data, and data collected during each customer interaction to create a set of actionable insights that it uses to make intelligent decisions. These decisions are known as the Next-Best-Action.**

Every Next-Best-Action weighs customer needs against business objectives to optimize decisions based on priorities set by the business manager.

A Next-Best-Action is designed as a series of decisions that execute in a hierarchical fashion. 

At the highest level, the Decision Hub selects the best actions related to a business goal, such as Retention, Service or Sales. Decisions defined at the business goal level determine the best action to be taken to achieve that goal.

All of this information is used by the Next-Best-Action decision strategy to evaluate every potential action that could be taken with a particular customer in a given situation. The decision strategy then recommends the best way to interact with the customer to achieve the optimal result.

Using the Next-Best-Action approach, the Customer Decision Hub is able to identify the best moments for making a sale, providing a service, making a retention offer, or doing nothing at all (e.g. if nothing is relevant enough to warrant the customer’s attention). 

Next-Best-Action is even able to select which offers are most likely to be accepted by the customer in a sales or retention situation. Next-Best-Action decisions are distributed, in real-time, to each of your real-time owned channels, such as web, mobile, and contact center.

A set of conditions decides the relevance of an action at every level.

The Customer Decision Hub uses two types of information to deteremine Next_Best-Action (NBA) recommendations:

* Call context.
* Customer Profile.

Two conditions must be met for the Customer Decision Hub to consider an offer for a customer:

* The **Active** attribute is set on the offer.
* The offer belongs to the **first relevant action** in the NBA hierarchy.

___

<a name="NBADesign"></a>
## NBA Designer

The Next-Best-Action Designer is a design wizard that automates the NBA strategy design process.

Designs can be either **Top-Down** or **Bottom-Up**.

In a Top-Down design, you start at the NBA node and work your way down the hierarchy to the issue-level node, and down again to the group level node. e.g. **NBA > Sales > CreditCards.**

The bottom-up approach reverses this, you start at the group level and deisgn upwards, through the issue-level node and up to the top level NBA node. e.g. **CreditCards > Sales > NBA.**

The idea behind these 2 approaches is that either is fine, it's about allowing different teams to work in parallel, and independently in the design phase.

___

<a name="prop"></a>
## Propositions

**Propositions are any customer facing offers, actions or messages.**

They can be presented on any customer interaction channel, web, mobile, contact center, social media etc.

Serviceing a customer's request is a valid proposition, even though it was the customer who initiated the request.

Every proposition has properties that define its characteristics:

* Price
* Benefit
* Product Image
* Short Title

Propositions are organized into a 3 level hierarchy to meet various business needs, such as **Sales**, **Retention**, and **Service**.

This Hierarchy is: **Business Issue > Group > Proposition.**

It can be customized into any hierarchal structure that meets the business needs.

<a name="pricing"></a>
### Dynamic Pricing

The **price** property can be set dynamically based on customer properties, such as customer value. Using the **Set Property** decision component achieves this. The properties can be set to a **constant** value or a **calculated** value. Set property decision components have access to **proposition** and **customer** properties.

<a name="priority"></a>
### Prioritization

Propositions can be ranked using a **prioritize** decision component. This component:

* Ranks propositions based on an expression.
* Selects the highest ranked proposition from the list.

<a name="audience"></a>
### Target Audience

The target audience of a proposition is selected using a **filter** to make decisions based on an expression, a condition, or the value of a property.

For example, you may have 20 credit card propositions. Applying a filter that checks that the value of the **.AnnualFee** property = 0 will filter out those propositions that do not meet this requirement. 

Adding another filter that tests that the value of **.Primary.CustomerType** == "Student" would filter out those customers who are not students. **".Primary"** gives you access to all customer properties.

The resulting propositions are credit cards with no annual fee, that are available to students only.

<a name="eligible"></a>
### Eligibility Criteria

Eligibility rules filter propositions based on **criteria**. e.g. customers must be over 18 to qualify for a certain type of credit card.

Eligibility rules can be applied to individual propositions or a group of propositions.

Eligibility rules in Pega are **When** rules. To implement an eligibility rule you must first create a **Proposition Filter** rule.

Both **cusomter** and **proposition** properties can be used in eligibility rules. To access a proposition property, just omit the ".Primary" from the property you are accessing. e.g. **.Age** is a proposition property, and **.Primary.Age** is a customer property.

___

<a name="data"></a>
## Data Analytics

There a different types of data analytics:

* **Descriptive** aka business intelligence. This looks back at existing data and visualises it.

* **Predictive**. This uses past data to find patterns and uses those patterns to predit what will likely happen in future.

Within predictive analytics there are 2 approaches. One creates **Predictive models** and the other creates **Adaptive models**.

Predictive models are created offline using historical data by people working with a predictive modeling tool. Pega provides the Prediction Studio portal to do this type of modeling.

In the other approach to predictive analytics, models are created in real-time without human intervention.

Adaptive analytics automates everything that can be automated in the predictive model development and execution process. No human intervention is required in the generation of adaptive models. As the user, all you have to do is create the model definition. The software then creates a **container** in which customer and behaviour data is captured in real-time. The software can then analyse the data and create new predictive models based on it.

<a name="predict"></a>
### Predictive Analytics

It starts with a data set, which is called a customer analytical record. This is a single record with lots of information about a customer. Each customer is labeled with a Case number, and all the data on that customer is associated with that Case number. The data includes profile information: name, address, age, gender, etc., as well as data about the customer’s past behaviour. 

The behavioural data shows the customer’s responses (accepts/rejects) to past propositions. All of this data is used to create a predictive model. But before the model can be created, we need similar data from other customers. 

The idea is that two customers with similar attributes, under the same set of circumstances, will make similar choices and therefore behave in the same way.

The most crucial and difficult part of Predictive Analytics is collecting enough data to find the attributes that will be good predictors of customer behaviour.

<a name="adapt"></a>
### Adaptive Analytics

In the case of adaptive analytics, there are typically multiple modeling processes going on at the same time.  For each proposition there is a predictive model. This allows us to calculate a customer’s propensity for each proposition.

Once the proposition is offered, and the customer’s response is captured, the new evidence is given to Adaptive Decision Manager, which uses it to refine the existing models. When new models are ready, Adaptive Decision Manager deploys them automatically into the Pega Decision Management decision engine.

<a name="predictVSadapt"></a>
### Predictive vs Adaptive

Predictive analytics requires historical data that contains the behavior you want to predict.

Adaptive analytics can start with no data and learn from the data gathered during customer interactions. Because adaptive analytics learn on-the-fly, model creation happens automatically.

With predictive analytics, you have more control over the model because its development is a manual process that you are directly involved in and can influence.

Predictive modeling uses a range of powerful techniques, and you can select the best model for your needs. Adaptive modeling is a fully automated process, and as a result, you have very little control over the techniques used to predict behavior.

Adaptive models learn constantly and therefore their performance changes over time, which makes the outcome less predictable than that of predictive models.

Predictive models should be used when predictability and compliance is important. For example, risk-related behavior such as credit risk, claims risk, and fraud are perfect calculations for predictive models.

Some behavior types don’t happen quickly. For instance, with loan defaults or churn, it can take months or even years to accumulate significant amounts of data. Predictive modeling should be used in these situations.

It is possible to implement hundreds of adaptive models in a solution because of the high degree of automation. As a result, predictive models are useful for determining more subtle and often high value behavior types.

___

<a name="history"></a>
## Interaction History

Interaction History gives Pega Decision Managements its long term memory. It captures every customer response to every NBA, even if the response is no response.

Interaction History can be added to a strategy using the **Interaction History** component.

___

<a name="sim"></a>
## Decisioning Simulations

Decisioning simulations enable you to execute a complex or simple decisioning strategy using a large customer sample and then examine the projected level of offer acceptance or rejection across a number of inbound and outbound channels.

Making multiple simultaeneous decisions like this is called **batch decisioning**.

To execute a decisioning simulation, instead of a single customer profile, we need customer data for a group of customers. In a simulation context, we call this simulation data, or input population. This data can be a real sample of the customer database, or some generated customer data, often making use of a Monte Carlo (random) data set.

In the simulation run, a decision strategy is applied against each customer in the population. The result of the simulation is stored in a database table or in a Visual Business Director (VBD) data source. When stored in a database table, you can analyze the reports using standard Pega Platform reports.

One of the most common use case for decisioning simulations is **A/B** testing. By completing 2 simulation runs we can generate 2 data sets that can be compared with each other. Testing two strategies against each other is also known as **champion-challenger**. The champion strategy is your default, and you run a challenger strategy against it. Strategies can be compared this way without taking a strategy into production. This is also called **what-if** testing.

___

<a name="arbitrate"></a>
## Arbitrtating between Propositions

Pega can use switch components to alter the output of a strategy based on customer intent. This enables a company to use **reactive retnention** in an attempt to keep a customer who intends to leave. e.g. a retention offer can be made if the customer intends to leave, or a sales offer can be made if the customer intends to make a purchase. The switch component evaluates a list of conditions in a top down order. When the first condition is met, the result of that component is output, the same as a switch statement.

___

<a name="credit"></a>
## Evaluating Customer Credit Score

Customers can be distributed into different segments using a **scorecard** component. A scorecard model is used to segment customers based on a calculation. e.g. customers with a credit score of >=175 qualify for a gold card, between 155 and 175 is silver, otherwise they are rejected. Since this calculation is separate from a filter, the scorecard model can be changed without having to change an entire strategy.

A scorecard must output at least 2 values, usually either **accepted** or **rejected**. To access the output of a scorecard you reference **ScorecardName.pxSegment**. This outputs the segment that the model has calculated. To access the actual values outputted by the model you need to enable **score mapping** when configuring the model.

<a name="decisionTable"></a>
### Decision Tables

The output of a scorecard component can used in a decision table.

**Any column left blank in a decision table is ignored, and returns true**.

Processing of a decision table stops once a condition is satisfied, like a switch statement.

___

<a name="holdings"></a>
## Product Holdings

When selecting which offer to make to a customer it is important that roducts that a customer already has are excluded from the ones offered.

There are 3 components used by a decision analyst to cheive this:

* Data Import
* Data Join
* Data Filter

A **Data Import** imports that associated data into the strategy, in this case the holdings of each customer.

A **Data Join** is then used to join the product holdings data to the main offers in the strategy. Specifying a join condition flags offers as "not relevant" when the holdings data matches the offer data.

A **Data Filter** then filters out these irrelevant offers.

___

<a name="3rdParty"></a>
## 3rd Party Predictive Models

**PMML = Predictive Model Markup Language**.

The Predictive Model Markup Language (PMML) is an XML-based language used to represent predictive models created as the result of a predictive modelling process. It allows for predictive models to be easily shared between applications. This XML-based language is the de-facto standard to represent not only predictive and descriptive models, but also data transformations (data pre and post-processing).

Predictive modelling is a commonly used statistical technique to predict future behaviour. Predictive modelling solutions are a data-mining technology that works by analysing historical data and generating a model to help predict future outcomes. In predictive modelling, data is collected, a statistical model is formulated, predictions are made, and the model is validated and revised as additional data becomes available.

PMML, like HTML is a Markup Language and as such is split into common components.                          

* Header – It contains general information about the PMML document

* Data Dictionary – It contains a definition of all raw data fields used by the model

* Data Transformation – It provides mapping of user data to a form used by the model

* Model – It contains a definition of the model itself

[Data Mining Group Documentation of PMML](http://dmg.org/pmml/v4-4/GeneralStructure.html)

___

<a name="adaptive"></a>
## Adaptive Analytics

**Pega Adaptive Decision Manager (ADM)** is a component that allows you to build self-learning adaptive models that continuously improve predictions for a customer. A key capability of ADM is that it can automatically detect changes in customer behavior and act on them in real time. This enables business processes and customer interactions to be instantly adapted to a customer’s changing interests and needs.

**Adaptive decisioning continuously increases the accuracy of its decisions by learning from each response to a proposition**.

<a name="adaptiveModel"></a>
### Adaptive Modelling Cycle

* Capture response data in real time from every customer interaction.

* Regularly:
  * Use sophisticated auto-grouping to create coarse-grained, statistically reliable numeric intervals, or sets of symbols.
  * Use predictor grouping to assess inter-correlations in the data.
  * Use predictor’s selection to establish an uncorrelated view that contains all relevant aspects to the proposition.
  * Use the resulting statistically robust adaptive scoring model for scoring customers.

* Whenever new data is available, update the scoring model.

Adaptive models accept 2 types of predictors: **symbolic** and **numeric**.

When adding new propositions to strategy models that contain an Adaptive Model, no changes need to be made. Modela are created on the fly when new propositions are taken.

Adaptive models produce 3 outputs:

* **Propensity** - This is the predicted likelihood of positive behavior, such as the likelihood of a customer accepting an offer.  The propensity for every proposition starts at 0.5 or 50%, because in the beginning the model has no response behavior on which to base its predictions.

* **Performance** - This is how well the model is able to differentiate between positive and negative behavior. Again, the initial value for each model is 0.5, with 1.0 being perfect performance. Therefore, the performance value should be somewhere between 0.5 and 1.0.

* **Evidence** - The number of responses used in the propensity calculation.

Performance and Evidence outputs are not mapped automatically, but they can be mapped to a strategy property in the **Output mapping** tab.

Model and Predictor performance is expressed as **area under the curve (AUC)**. A high AUC describes a good predictor and a low AUC is a bad, or inaccurate, predictor. The AUC value shows how much better or worse the model is when compared to a random selection.

___

<a name="text"></a>
## Text Analytics

This is the process of extracting meaning from text on a massive scale, converting it to data that can be analysed by a computer.

The process is: 

* Data is fetched from a **data source** such as email, social media, or customer service records.

* **Natural Language Processing (NLP)** is applied to extract certain attributes from the text and presents them as data.

* The resulting data is **stored and analysed**.

<a name="email"></a>
### Email Routing

Pega Infinity uses AI-powered Natural Language Processing to detect the topic of an email and route the email to the appropriate container.

Email routing is done using the topic detection mechanism. The two types of topic detection are **rule-based** and **model-based**.

In **rule-based** topic detection the routing is based on the rules configured in the email channel. AI-powered text analytics is used to detect the topic of the email, and the channel rules route it to the right container. This type of topic detection may detect one or more topics if the email contains words associated with more than one topic. In this case, the email is routed to two different containers based on those topics.

In **model-based** topic detection the routing is based on AI models built by a Data Scientist using machine learning. Building these models requires a training data set and a test data set. The data sets consist of a list of emails and the associated topic for each email. This type of topic detection identifies the most accurate topic based on the AI model and training set used by the Data Scientist.

Pega Infinity also enables you to extract entities from an email. This means that when an email is sent, certain entities such as account number, email address, street address, etc. can be automatically detected and extracted. This allows certain emails to be automatically processed or given priority.

Pega Infinity also uses its AI-powered text analytics to enable you to detect the sentiment of an email based on its content.

The sentiment score is a value between -1 and 1. In the out-of-the-box configuration, a sentiment score <=-0.25 results in a Negative sentiment, a sentiment score between -0.25 and 0.25 results in a Neutral sentiment, and a sentiment score above 0.25 results in a positive sentiment.

Once the email sentiment is detected, you can configure the email channel to route a specific topic with a specific sentiment to a specialized agent for a quick and personalized response. For example, you could route an address change with a neutral sentiment to a Service Agent, a complaint email with a negative sentiment to a Manager, and a credit card inquiry with a negative sentiment to a Financial Services Specialist.

___

