# Pega SSA Notes (Senior System Architect)

## Contents

* [Enterprise Class Structure](#enterprise)
  * [Enterprise Class Structure Layers](#layers)
* [Application Versioning](#version)
* [Application Rulesets](#rulesets)
* [Managing Application Development](#dev)
* [Rule Resolution](#rule)
* [Circumstancing](#circumstance)
* [Duplicate and Temporary Cases](#cases)
* [Parallel Processing](#parallel)
  * [Case Locking](#lock)
* [Flow Action Processing](#flow)
* [Decision Tables and Trees](#decision)
* [Case Approval](#approve)
* [Organizational Records](#organize)
* [Configuring Field Values](#fields)
* [User Portals](#portal)
* [Application Accessibility](#access)
* [Localization](#localize)
* [Keyed Data Pages](#keyed)
  * [Data Access Patterns](#accessPattern)
* [Database Updates](#database)
* [Data Integration](#integrate)
* [Simulating Integration Data](#simulate)
* [Integration Setting Management](#integrateSetting)
* [Integration Errors](#integrationError)
* [Web Services](#web)
* [Desigining Reports with Multiple Sources](#reports)
* [Application Security](#secure)
* [Web Mashups](#mashup)
* [Activities](#activity)
* [Background Processing](#background)
* [Debugging and Performance](#debug)
* [Relevant Records](#relevant)
* [Application Migration](#migrate)
* [Mobile Apps for Pega Applications](#mobile)
  * [Offline Processing for Mobile Apps](#offline)
___

<a name="enterprise"></a>
## Enterprise Class Structure

Pega lets you organize your application in the same way as your business. You can reuse common policies and procedures while allowing for differences between products, regions, channels, and customer segments.

This is acheived by using a class hierarchy structure called **Enterprise Class Structure (ECS)**.

From top to bottom this is:

* Application-specific policies and procedures
* Division-specific policies and procedures
* Enterprise-specific policies and procedures

Any rule in an ECS layer can be shared across multiple applications, and can be edjusted as business operations change. ECS also enforces best practice around reuse and standardization as a system expands.

<a name="layers"></a>
### Enterprise Class Structure Layers

#### Pega Platform Layer

The Pega Platform layer contains the built-in assets necessary for processing cases and other work in Pega applications. This layer also contains the assets Pega Platform uses.

#### Organization Layer

Contains assets used on an enterprise-wide basis. This includes rules for things like standard properties, decision tables, and service level rules. 

Also contains data such as assets and rules for data stored in the system, and data stored for accessing external system data. e.g. access to an external customer database is an integration point that may be added to the Organization layer.

#### Division Layer

Contains assets used on a division-wide basis. This is the middle level of the **(Org-Div-Unit)** heirarchy and is available for use in every application.

Assets in this layer may apply to a line of business, region, or brand. A rule here is available to all applications within the division through pattern inheritance. 

#### Framework and Implementation Layers

The **Framework** layer contains assets that can be extended in specific implementations. This could be a standard Pega application for a certain industry, or an extendable custom application.

The **Implementation** layer defines an application customized for a specific division or line of business. This may extend one or more framework layer applications.

For example, a dealer may have two brands, one focussed on luxury cars, and one on value for money cars. Each brand needs to manage sales. The dealer can use a generalized application that manages sales in the framework layer. Each brand can then extend this on the implementation layer to customize their own sales process. Each custom application contains brand-specific assets, such as styling and policies.

___

<a name="version"></a>
## Application Versioning

**When creating a new application version it is best practive ensure that the rules for the new version are checked in, and to lock all but the highest ruleset versions before proceeding**.

Pega provides two methods for creating new versions of an application. Each method preserves prior application versions. Application versioning is a way to differentiate current and past application configurations. Rule resolution can look through all the minor and patch versions for the current major ruleset.

Application components include the application **ruleset stack** — this contains the rules and data types used by the application. To version an application, you must version the application's rulesets.

The versioning methods are **lock and roll** and **skimming**. The act of using a version method begins a release cycle. Every major version, minor version, and patch version represents a release cycle. Both methods list the highest version, and offers to roll the ruleset to a still-higher version by default.

**Loack and Roll** is best for incrementing **patch** versions, and **Skimming** is better for **major** and **minor** versions.

### Lock and Roll

When using this method you create a new empty ruleset version and copy the necessary rules into that new version.

When updating a version, Pega checks the previous minor version to find existing rules. Pega cannot find rules if they exist in a different **major** version.

There are 3 options when updating the application rule:

* **Do not update my application** is used when applying a patch update.

* **Update my Application to include the new Rulset Versions** is used when you are rolling out a new minor version, or when the application rule lists the patch number.

* **Create a new version of my application** is used when:
  * You want to create a new application rule. This could be creating a new version or description of the application.

  * You want to allow access the current and new versions of the application, during a test peroid or phased roll out for example.

### Skimming

Skimming saves the highest version of a ruleset into a new, higher ruleset version; and applies mainly to resolved rules. The two types of skimming are **major** and **minor** skimming, and these correspond to the update types.

If a rule is available, blocked, final, or withdrawn, it is carried forward when skimming. The only exception is that withdrawn rules **are not carried over** in a major skimming update.

After performing a skimming update, you must update:

* Application rules
* The required rulsesets and versions array in RuleSet version rules
* Access groups, to reference the new major version

___

<a name="rulesets"></a>
## Application Rulesets

Every type of rule belongs to a **ruleset**, which is a container used to identify, store, and manage a set of rules.

When a new application is generated, four rulesets are created, two for the application itself, and two organizational rulesets. For example, the application rulsets contain configuration rules, and the organizational rulesets contain reusable assets such as data structures.

**Production rulesets** have at least one unlocked ruleset version in the production environment. Production rulesets include rules that are updated in the production environment. The most common use of production rulesets is for delegated rules. However, production rulesets can be used for any use case requiring rules to be updated in a production environment.

Ruleset validation is performed every time a rule is saved. It guarantees that referenced rules are available on the target system when the ruleset is promoted.

Ruleset validation does not affect rule resolution at run time but is applied only at design time.

The two options for this are **Application Validation (AV)** and **Ruleset Validation (RV)**.

App rules are set to **AV** mode to reduce the difference between design and runtime.

Org rules are set to **RV** mode to ensure strict validation on prerequisite rulsets when migrated.

Rules in **AV** mode can reference all rules in the same application, and any rules in a built-on application can reference those in the application on which they are based. AV rules in an app **cannot** reference rules in an app that is built on top.

Rules in **RV** mode depend on prerequisite rulests. Only rules that are specified as prerequisites (and their prerequisites) can be referenced.

**Rules without prerequisite rulesets must reference the base product *Pega-ProcessCommander* as a prerequisite. There is a 99 patch version of this ruleset, and using it avoids having to update the ruleset after product updates**.

AV and RV rules can be mixed. Rulesets with another ruleset in square brackets are RV, with the bracketed ruleset being the prerequisite. E.g. MyCoPL [MyCo].

Rulesets without another bracketed ruleset are AV.

**RV rulesets cannot call AV rulesets that are not prerequisties**.

### Ruleset Best Practices

* Only use RV for rulesets that are designed to be used across multiple applications, such as organizational rulesets, to make them easily portable and prevent the introduction of dependencies on a specific application.

* Create applications for common rulesets; use the built-on functionality to include common rulesets in the application.

* Include unlocked AV rulesets in one application only. Doing so prevents AV rulesets from referring to rules that may not exist in applications that do not contain the ruleset.

* Run the Validation tool after implementation of critical changes or milestones (for example, changes to the application ruleset list or built-on application as well as changes made before lock/export).

### Ruleset List

Rule execution at runtime is governed by the **Ruleset List, or Ruleset Stack**. Ruleset higher up the list have higher priority.

___

<a name="dev"></a>
## Managing Application Devlopment

A **branch** in Pega is a container for rulesets with records that are undergoing rapid changes. Rulesets associated with a branch are called **branch rulesets**.

Branches are usually created for each team and allow development to occur without impacting other teams' work.

___

<a name="rule"></a>
## Rule Resolution

Rule resolution is a search algorithm used to find the most appropriate instance of a rule to execute in any situation.

Rule resolution applies to most rules that belong to the **Rule** base class, such as:

* Case types - **Rule-Obj-CaseType**
* Properties - **Rule-Obj-Property**
* UI rules - **Rule-HTML-Section**
* Declare expressions - **Rule-Declare-Expression**
* Data Pages - **Rule-Declare-Pages**

When a rule is referenced in a Pega application, rule resolution attempts to locate instances of the rule in the rules cache. If instances of the referenced rule are found, rule resolution finds the best instance of the rule and checks for duplicates. Then Pega confirms the rule is available for use. Finally, Pega verifies the user is authorized to use the rule.

If instances of the rule are not found in the rules cache, Pega runs a special sub-process to populate the rules cache.

The point of the rule resolution is to return the most appropriate rule to satisfy the need of a specific user for a specific purpose.

When your application references a rule, Pega checks the rules cache for the referenced rule. If the referenced rule is not available in the rules cache, Pega uses a multiple-step process to populate the rules cache.

The rule resolution algorithm: 

* Creates a list of all rules that match the query to populate the cache.
* Rules marked as **Not Available** are removed.
* Uses the operator's **Ruleset list** to determine which rules the operator can access.
* Removes all rules not defined in a class in the ancestor tree.
* Ranks the remaining rules.
* Adds these rules to the cache.

Rules that are subject to the rule resolution process have an Availability setting. The current Availability of a rule is visible on the rule form next to the rule name or description.

The Availability setting is used to determine if a rule is available for use during rule resolution. The availability of a rule is also used to determine if you can view, copy, or edit a rule in Dev Studio.

The availability of a rule can be set to one of five values:

* **Available** - rule can be used in the rule resolution process. This is the default setting when a rule is created. By default, a rule can beviewed, copied, edited, and executed in Dev Studio.
* **Final** - rule can be used in rule resolution, but cannot be edited or copied into another ruleset.
* **Not Available** - cannot be used in rule resolution. Can not be executed.
* **Blocked** - rule can be used in rule resolution, but will not execute. If selected in rule resolution, the process is halted and returns an error.
* **Withdrawn** - rules that are in the same ruleset with a <= version number, the same purpose, and *Apply to:* class are hidden and not considered in rule resolution. These rules do not execute.

___

<a name="circumstance"></a>
## Circumstancing

**Circumstancing** is creating a variant of a rule to manage certain exceptions in otherwise normal processes. e.g. customers with "basic" membership receive responses after 24hours, but those with "elite" status receive a response after 6 hours. Instead of creating a separate rule for elite customers, you take advantage of **circumstancing**.

This allows you to customize the behaviour of an application to address multiple exceptions using a collection of targeted rules rather that a single complex rule.

Circumstancing establishes a baseline for expected case behavior and adds variants to address exceptions to the behavior. The goal of circumstancing is to create a variant for each anticipated situation. Pega selects the appropriate variant, or circumstance, to use based on the details of the case.

You can circumstance a rule according to the value of one or more conditions. You define a condition based on one variable, multiple variables, or the processing date, then apply the condition to a variant of the rule. When using the rule, the application evaluates the conditions defined on all the circumstanced variants. If one of the circumstancing conditions is satisfied, the application uses the corresponding rule variant. Otherwise, the application uses the base rule.

There are 4 circumstancing conditions:

* **Single value** - the rule variant is effective whenever the value of a single property satisfies the circumstancing condition. You specify the property to evaluate a comparison value when circumstancing a rule. If the value of the property matches the specified value for a case, the application applies the circumstanced variant of the rule, rather than the base rule.

* **Multiple value** - the rule variant is effective whenever a combination of property values satisfies the circumstancing condition. Multiple value circumstances are based on a circumstance **template** and circumstance **definition**. The circumstance **template** defines the properties on which to circumstance a rule. The circumstance **definition** defines the combination of conditions in which a property uses a variant of a rule. You apply the circumstance template and circumstance definition to the rule variant. If the case matches a combination in the circumstance definition, the application uses the circumstanced variant of the rule, rather than the base rule. This is also called **multivariate circumstancing**.

* **Date property** - the rule variant is effective whenever the value of a date property satisfies the circumstancing condition. This condition can be either a **single date** or a **range of dates**. If the value of the property is **later** than the specified date or **falls within the range of dates**, the application uses the circumstanced variant of the rule, rather than the base rule.

* **As-of date** - the rule variant is effective **after** a certain date, or during a **range of dates**. After the speified date or during the specified range, the application applies the circumstanced variant of the rule, rather than the base rule.

To circumstance a rule based on one variable, select cirumstance by **Property and Date** when creating the rule variant.

To circumstance based on multiple variables, select circcumstance by **Template**. 

For each cirumstanced rule you must also provide a unique **circumstance definition**. This defines the values for the circumstance template.

### Overriding a Circumstanced Rule

Circumstanced rules can be overidden in 2 ways:

* **Flagging a base rule** - the base rule incdicates that this version of the rule is now considered this rule's base and any previous circumstances no longer apply.

* **Withdrawing a rule** - A withdrawn rule hides previous circumstanced versions of a rule and reverts to the base rule.

When selecting which rule to use, Pega looks to the newest ruleset version **regardless of circumstancing**. e.g. If your have two rulesets, **01-01-42 (no circumstance)**, and **01-01-20 (circumstance you want to use)**, Pega will run the most recent rulset. In this case, **01-01-42**.

___

<a name="cases"></a>
## Duplicate and Temporary Cases

### Duplicate Cases

Duplicate cases can be found using the **search duplicate cases** step in a case life cycle. When a case enters the step, the system uses **basic** and **weighted** conditions to compare specific property values with cases already present in the system. 

All basic conditions must be met before considering potential duplicate cases. Once all basic conditions are met, the system continues to evaluate the weighted conditions to receive a weight value. Each condition has a weight (between 1 and 100) to determine the relative importance of a condition when making the comparisons. 

The system adds up the weights of all the conditions that evaluate to true. If the sum exceeds a specified threshold value, the system flags the current case as a potential duplicate. 

The search duplicate cases process then displays to the user the current case and the matching case in the system. The user may identify a potential duplicate from the list and resolve the current case as a duplicate. The system does not process the case further. The user may also decide that the current case is not a duplicate and may choose to continue processing the case.

### Temporary Cases

**Temporary cases are only stored in memory, on the clipboard and do not have case ID's. This is useful for saving storage and improving system performance**.

Once a case meets the condition specified by the organization, such as a customer change of address where the address entered is different from the current address, the case can be recorded in the database (persisted) for future reference.

Temporary cases are processed by a single operator and cannot be routed until they are persisted.

___

<a name="parallel"></a>
## Parallel processing

You use the **Split Join** shape to call multiple processes that operate in parallel then rejoin the main flow. **Join conditions** can be specified to determine when the main process can continue.

A **Split For Each** is used to run a subprocess multiple times by iterating through a set of records in a page list or page group. When the items have been processed, the main flow continues.

**Spinoff** subprocesses allow you to run a subprocess in parallel to the main flow. The main process does not wait for the spinoff to complete befoire proceeding. 

The Join conditions for parallel processing are:

* **Any** - Main flow resumes when any of the conditions are met. Other subprocesses are stopped if they are not complete and open assignments for these subprocesses are cancelled.

* **All** - Main flow only resumes when all subprocesses are complete.

* **Some** - Uses a when rule or a count to determine when the main process can resume.

* **Iterate** - On the **Split For Each** shape, this starts flows for items in the page list or group and tests an optional when condition to determine whether to start a flow for a given iteration.

<a name="lock"></a>
### Case Locking

The default type of case locking in Pega is **Allow one user**. This locks a case when an operator opens it. If a second operator tries to open the same case, they can only do so in **review mode**. Pega locks the case for **30 minutes** or until the **user submits or closes the case**, whichever comes first.

**Allow multiple users** enables multiple operators to update the same case at the same time. A lock only occurs when the user submits the case. Changes are made by whichever operator submits first. When a second operator submits, they must refresh the case to get the new changes made by the first operator. The second operator can then submit their changes. 

Cases are locked on **parent** cases, and cascade down to any child cases created, the default being **allow one user**. This can be overwritten at the **child** case level, when multiple users need to access the child cases.

___

<a name="flow"></a>
## Flow Action Processing

**In Pega, you can add pre- and post-processing actions to a flow action to manipulate data. These actions enable you to add related tasks to the flow action. For example, you can concatenate a person's first name and last name to create their full name**.

Pre-processing begins when a user selects a flow action as well as when the user is presented with the assignment. So if a user completes an assignment, then returns to is later, pre-processing will happen again. Logic can be added to test whether this should happen.

Pre-processing actions could be running a data transform, initializing a value, or initializing a list.

Consider the possibility of reuse when decising whether to use a pre-processing action. If a pre- or post-processing action applies to only one case type, then specialize the flow action for the case type instead of adding the pre-or post-processing action.

___

<a name="decision"></a>
## Decision Tables and Trees

Decision tables are used when you need to test the values of multiple properties to make a decision.

Decision tables are laid out like spreadsheets, with rows and columns. 
A decision table is a table of conditions and results. You define a set of conditions – for example, property values that must fall within a certain range – and the results to return when the conditions are true. Each set of conditions contains a corresponding result. You can add columns for each condition you want to test against – either a property reference or an expression – and rows for each combination of conditions you want to test.

When the system evaluates a decision table, it starts with the top row and evaluates each condition in the row. If **all of the conditions are true**, the system returns the result for that row. If not, it advances to the next row, and evaluates the conditions in that row. And if none of the combinations returns a result, the system returns the **otherwise result** at the bottom of the table. This ensures that the r decision always returns a result.

A decision table uses an **equals** condition by default to evaluate a condition. **Greater than** and **less than** can be used when evaluating numerical conditions.

Enabling the **Evaluate all rows** option on a decision table makes that table evaluate all of its rows and return an array of the results.

### Decision Trees

Decisoin trees can also be used to handle logic that calculates a value from a set of test conditions.

While decision tables evaluate against the **same set** of properties or conditions, decision trees evaluate against **different** properties or conditions. While a decision table stops execution when it gets a **true** result, a decision tree can make additional evaluations after getting a **true** result.

A decision starts at the top of a decision tree and proceeds downwards, each **true** result advancing the decision process.

Decision trees contain condition branches — a comparison value, a comparison operator, and an action. The action can be to return a result, to continue the evaluation, or stop the evaluation. The branches are organized in a hierarchical tree structure. Typically, you specify common conditions and results at the trunk of the tree. You then extend the tree outward to more-specific conditions and their actions. When the decision tree is invoked, the system evaluates the top row and continues until it reaches a result that evaluates to true. The result is returned to the system. If the system processes through all the branches but does not reach a returned result, the system returns the final otherwise value.

Decision tree branches can be nested. For example, if a pruchase request is for **> $100**, the request must be routed for approval. Two possible outcomes of approval exist and must now be evaluated. If a purchase request is for **< $100** (the original condition is false), the two approval outcomes **do not** need to be evaluated.

The structure of such a decision tree might look like this:

* Purchase Request > $100 then continue
  * If department == Consulting then return Compliance
  * Otherwise return Work Manager
* Otherwise return No Approval Needed

Clicking **Show conflicts** when creating a decision tree shows any unreachable conditions.

Clicking **Show completeness** adds rows to indicate values that will not be evaluated. These are suggested conditions to add.

___

<a name="approve"></a>
## Case Approval

Cases can either be **single approval** or **cascading approval**.

The two types of cascading approval are **Reporting structure** and **authority matrix**.

You use the reporting structure model when approvals **always move up** the reporting structure of the submitter or another defined list.

You use the authority matrix model when a set of rules directs the approval chain to individuals both inside and outside the organization of the submitter.

An authority matrix uses a decision table. The decision table identifies each party in the approval process as well as the conditions that determine when each party must provide approval.

The application evaluates the decision table. Each satisfied row or condition adds the results to a (page) list of approvers. Approval assignments route to approvers in the order of list appearance.

___

<a name="organize"></a>
## Organizational Records

**A Pega application uses an organizational structure to direct assignments to the right operator or work queues, determine the access rights of operators, and report on activity in various company departments**.

The Pega organizational structure is a three-level hierarchy. The top level is known as the **organization**, the middle level contains **divisions**, and the lowest level contains organization **units**.

* A heirarchy has only one **Organization**, representing the entire enterprise.

* A **division** represents a category of a business unit such as a regions, brand, or department.

* A **unit** contains operators wh operform work specific to their organization. This could be caseworkers, agents, and customer service representatives. 

A unit can have **child units**. For exmaple, two units (Hardware and Software) may report to a parent unit (Internal) in the IT division.

An operator is associated with a unit, division, and organization. The operator ID record (also an organization rule) stores the organizational structure of the operator. You can update the organization structure, if necessary.

___

<a name="fields"></a>
## Configuring Field Values

When building an application, you often need to use a list of allowed values for a specific property. If the list of allowed values is large, expected to change frequently, or may be specific for each case type, you can use a **field value**.

**Field values** enable you to manage the list of allowed values separately from the property. Managing the allowed values separately from the property enables you to reuse a single property, and customize the allowed values based on the context of the property.

You can create field values to restrict the values of a property to a list of allowed values.

<a name="portal"></a>
## User Portals

A **user portal** is a user's view into the application. Pega provides a few default portals, customized to the needs of a specific user. For example, case workers or case managers.

A **Harness** is used to structure the UI of a portal. There are four commonly used harnesses in Pega:

* **New** - for creating new cases.
* **Perform** - enables users to select a flow action to perform in order to complete an assignment.
* **Review** - presents an assignment in read-only mode.
* **Confirm** - presents a read-only comfirmation of a completed assignment if the next assignment is not performed by the user.

Harnesses allowing users to select a flow acction contain an **action area**. When a user selects a flow action to perform, Pega displays the contents of that flow action in the action area.

Harnesses that organize a user portal contain a **screen layout**. A screen layout organizes the elements of the browser window into a main content pane and smaller surrounding panes.

The default user portals can be customized, and custom portals can be created from scratch.

In Pega, a portal is represented with a **portal rule**. A portal rule identifies the type of user expected to use the portal, the harness used to organize the portal contents and the skin that defines the branding applied to the portal.

To configure a Pega portal you:

* Identify the intended user role and portal type.
* Organize the layout of the portal.
* Customize the branding of the portal.
* Customize the content and tools available to users.
* Configure an access group to reference the portal if necessary.

Pega supports two portal types: **composite** and **custom**. Composite portals are defined by harnesses and sections. Composite portals are cross-browser compatible and support Microsoft Internet Explorer, Mozilla Firefox, Apple Safari, and Google Chrome browsers. Custom portals are defined by an activity. As a best practice, configure a new portal as a composite portal.

___

<a name="access"></a>
## Application Accessibility

**Web Accessibility Initiative - Accessibile Rich Internet Applications (WAI-ARIA). Is a technical standard that defines ways to make web content and applications more accessible to people with disabilities**.

This is done with **accessibility roles**. These are specific attributes applied to UI elements that enable communication between assistive devices and Pega applications. There are roles that direct a screen reader to differentiate between a checkbox and a button for example.

Accessibility roles are provided to individual **access groups** and exist in the **PegaWAI** ruleset.

There are a few functions that are in a standard ruleset in Pega, so don't require the PegaWAI ruleset. These include:

* Setting tooltips to be read by a screen reader.
* High contrast colour scheme.
* Keyboard controls for tabbing through a UI.
* Links with icons that can be described by a screen reader.
* Provide a list of drop down options that can be read by a screen reader.

The **Accessibility Inspector** tool in Pega can be used to identify and correct accessibility issues. There are two main features that aid accessibility design:

* **Disability Preview** allows you to view your application through each variation of colourblindness.

* You can audit your application UI to identify configurations that may negatively impact accessibility. The four categories that can be assessed are:

* **Content** - an icon or tooltip is missing for example.

* **Structural** - The heading heirarchy is out of order for example, confusing screen readers.

* **Interactivity** - Options are not configured to allow a user to press a key to navigate content for example.

* **Compatibility** - Deprecated layouts (tab layout) is used instead of a layout group for example.

___

<a name="localize"></a>
## Localization

The five ways to adapt to regions using localization are to accommodate the local language, currency, date format, time zone, and time format.

You define **Field Value** rules for those rule types that use labels or other text strings under 64 characters. For example, a property reference in a section can use a field value as the label text. Applications translated into other languages have a field value with the translation for each UI form property.

Paragraph rules make content reusable. Instructions on a UI form, copyright declarations, and privacy notifications are all examples of reusable paragraph rules. Paragraphs longer than 64 characters can be kept intact as boilerplate content and easily applied multiple times in an application. For example, the instructions at the top of a form can be translated into Spanish and can now be reused in several places in the application.

Text used in paragraphs, correspondence, and correspondence fragment rules are packaged and output in a pair of HTML files, **Base.html** and **Translation.html**. Both files contain the same text until the **translator** puts the translated text into the **Translation.html** file.

### Desigining for Localization

To ensure you design your application for localization you create **field value** rules for capturing labels and notes, **paragraph** rules for instructions and messages, and **correspondence** rules for emails and other correspondence. Once these elements have been added to your application, they can be localized for virtually any language.

___

<a name="keyed"></a>
## Keyed Data Pages

A Keyed Data Page is a page that references another data page. This allwos an application to retrieve data more efficiently by reducing the number of server requests, for example. You can use a keyed data page to load product information to a data page on the first query of the day. When a user submits a request in an online store, the data is returned from the **preloaded** (keyed) data page instead of making a fresh server request.

When using **non-keyed** data access, a trip to the data source is required for each unique query.

When using **keyed** data access, data is preloaded in memory and results can be immediately displayed.

Keyed data pages are best used when many server requests are made while data in the server remains unchanged.

<a name="accessPattern"></a>
### Data Access Patterns

Data access patterns provide simple ways to manage data in a Pega application. There are three patterns, and the choice of pattern impacts the storage and refreshing of data in a case.

* **System of Record** - provides access to data stored in another system or application. The application always references the system of record, so the data is always correct.

* **Snapshot** - copies data into a case. The application always references the copied data, so it is only current as of when it was copied.

* **Reference** - allows an application to use data without adding it to the data model of the application itself. Often used to populate UI controls such as dropdown lists.

___

<a name="database"></a>
## Database Updates

There are three main databases that Pega works with:

* **PegaRULES** - contains all of the rules and system info for a Pega application.

* **PegaDATA** - contains info such as cases, assignments, and case history.

* **External Databases** - creating an **external class** allows you to manage the data read from and written to an external database.

___

<a name="integrate"></a>
## Data Integration

Pega integrates with external systems using **connectors**. You can parse, convert, and map data in either direction to or from the clipboard with a connector. 

You can invoke Connectors from data pages and activities. Use data pages to read or pull data from the external system. Use activities to write or push data to the external system.

The invocation of a connector involves five components:

* Data page or activity – Specifies the connector to use and data transforms for request and response mapping.

* Data transforms – Maps the data structure of your application to the integration clipboard pages, which correspond to the format expected by the service.

* Connector rule – Uses the integration clipboard pages to build the request according to the protocol and service definition, invokes the service, and parses and places the response on the integration clipboard pages.

* Mapping rules – For most connectors, mapping rules are used to build outgoing and parsing incoming messages.

* External system – Exposes the service called

Pega provides connectors for a wide range of industry-standard protocols and standards. Standard connectors include SOAP, REST, SAP, EJB, JMS, MQ, File, and CMIS.

When an external system requests data from a Pega application, Pega can provide it using **services**. Services allow you to expose the data and functionality of your application to external systems.

You can parse, convert, and map data in either direction to or from the clipboard, much like with connectors.

Pega provides services for a wide range of industry-standard protocols and standards, including SOAP, REST, EJB, JMS, MQ, and File.

___

<a name="simulate"></a>
## Simulating Integration Data

Pega provides the ability to simulate integrations with services for testing purposes or when the data source is unavailable. You simulate an integration to unit test the **integration connector**.

**It is useful to simulate an integration when the service is not available or when the response needs to be dictated**.

___

<a name="integrateSetting"></a>
## Integration Setting Management

Before an application is live, it moves through many environments. Typically, applications go through development, staging, QA, and production. When migrating an application from one server or environment to another, references to the external systems connected to the application (such as endpoint URLs and JNDI servers) typically change. The information required to connect to these external systems must be modified, depending on your environment.

Using the **Global Resource Settings** pattern to reference external systems ensures that you do not miss changing a setting when moving from staging to production. 

In this pattern, you create a class that contains the configuration settings for an integration that has values able to change from one environment to the next. You then have your resources access a data page to load those settings. This data page allows you to have a place to maintain and update these settings.

___

<a name="integrationError"></a>
## Integration Errors

Two types of errors can occur when trying to integrate to an external system using a connector:

* **Transient** - don't last long and typically fix themselves. For example, the connector is unable to connect because the application is being restarted and is temporarily unavailable.

* **Permanent** - typically due to a configuration error, or an error in the remote application logic. For example, an invalid SOAP request is sent.

**It is best practice to include error handling for all connectors**.

For transient errors, post a note to alert the end user that the integration failed. Ask the user to retry at a later time. Alternatively, if the response is not immediately needed, the connection can be automatically retried.

For permanent errors, write the details to a log file so that errors can be investigated and fixed. In addition, you might want to implement a process for the investigation and fixing.

The way errors are detected depends on how the connector is invoked. Connectors can be invoked by data pages or activities. When data pages and activities invoke a connector, the best practices are to:

* Add error detection to all data pages and activities

* Invoke a reusable data transform to handle errors

Pega provides a template data transform called **pxErrorHandlingTemplate**. This can be used to create a reusable error handling data transform. The error handler data transform can be used with both data pages and activities.

In addition, each connector has an error handling flow (called **Connection Problem**). Pega automatically invokes the error handler flow if the error is not detected by another mechanism.

**To configure error detection for a date page, create a new data transform for error handling. It should be created from the standard *pxErrorHandlingTemplate* data transform**.

___

<a name="web"></a>
## Web Services

**The two most common ways to expose your application as a service are either to create a web service or to leverage the Pega API**.

These work the same way, a request is made to a URL and a response returned. The difference is how each method communicates with the service.

The Pega API can call any service using the standard HTTP methods GET, POST, PUT etc.

SOAP services need to be created in Pega, and use the SOAP protocol to pass XML messages from one application to another.

A combination of rules are used to make a SOAP service request:

* **Service Activity** - provides the processing for a service rule.

* **XML Parser** - maps data from an XML message into clipboard property values.

* **XML Stream** - assembles and sends an XML doc in an email, a SOAP message, a file, or other types of messages.

* **Service Package** - groups one or more sservice rules that are designed to be developed, tested, and deployed together.

___

<a name="reports"></a>
## Designing Reports with Multiple Sources

**Any Pega class can be mapped to a database table**.

Reports use **class mappings** to locate data from one or more tables.

Pega uses two records to identify the database table that a class is mapped to:

* **Database** - identifies how Pega connects to a specific database. Contains connection information so Pega can access the database.

* **Database Table** - identifies a specific table in a specific database, and specifies the corresponding Pega class. Pega uses this record to identify which table to write case data when a user creates or updates a case.

To have multiple classes store data in the same table, you designate a class as a **class group** (or **work pool**). Class groups cause the system to store instances of similar or related case types together in a single database table. If you create a report in a specific case type such as Candidate, your report returns only records in the case type. If you create a report in the class group, the report returns all instances in the classes that belong to the class group.

You commonly generate three types of reports: work, assignment, and history. Each type of report uses properties in classes mapped to a variety of data tables.

### Work

When a case is created, PEga uses standard properties in the *Work-base* class to define each case. These are:

* A case identifier *pyID*, the work parties involved *pyWorkParty*.
* A customer identifier such as an account no. *pyCustomer*.
* The work status of the case *pyStatusWork*.

### Assignment

Cases requiring user interaction are assigned to a user during processing. Each time a case is assigned, Pega creates an assignment object. When the case is completed and advances to the next assignment, Pega creates another object. If the assignment is routed to an operator, Pega saves the object to the database table named **pc_assign_worklist**. If the assignment is routed to a workbasket, Pega saves the object in a database table named **pc_assign_workbasket**.

### History

When a case is being processed, the system automatically captures audit trail data in the history classes. The classes are mapped to the History database tables where the data is saved. For example, the history class **History-TGB-HRApps-Work** is mapped to **pc_History-TGB-HRApps-Work**.

History reports use properties in the **History-** and **History-Work-** classes. These properties include **pyHistory type** (identifies the event that caused the history event), and **pyPerformer** (identifies the operator who completed the event recorded in the history instance).

Properties in history classes can be used to design performance-based reports. For example, you can use **pxTaskElapsedTime** to report the total time spent on an assignment. If an assignment is routed to multiple users, you can use **pyPerformTaskTime** to report on the total time spent by all users. If **pyPerformTaskTime** is significantly lower than **pxTaskElapsedTime**, then the assignment has been idle for a long time.

When you build a class relationship in a report, you configure a **class join**.

To do so:

* Determine the class to which you are joining.
* Create a prefix that in combination with the class name, serves as an alias for the joined class.
* Decide whether you want to include or exclude instances that do not match.
* Create a filter that describes how you relate the classes.

**Association rules** also join multiple classes, but unlike class joins, can be resused across reports. Pega provides standard association rules that can be used to join many classes.

**Subreports** enable you to reference results from any report definition in a main report. They can be defined in classes different from the main report. You can access data in different classes in a similar way that class joins or associations do.

Subreports are typically used to satisfy complex reporting requirements. They can be used to filter results, for example. They can also be used to display aggregate calculations on specific rows in a main report.

The two methods to create subreports are **join filters** and **aggregation**.

___

<a name="secure"></a>
## Application Security

**Access Control** is used in PEga to provide security.

It is configured as either **role-based** or **attribute-based**, for more security.

* Role based restricts access to specific instances classes or properties within instances independent of an access group role.

* Role based restricts users' roles access to certain UI elements, to perform only certain actions in the UI, or to have any access to a class.

Access control depends on two factors:

* **Authentication** - confirms the identity of a user and verifies that the user has access to an application.

* **Authorization** - determines what data the user can view and the action they can perform.

A user can belong to multiple access groups, but only one is active at a single time.

In Pega, you define an access role with an **Access Role Name** record, a label that describes a specific set of application users with a unique job function. You apply the role to **Access of Role to Object** and **Access Deny** records to identify the actions allowed or denied to users assigned the role.

You create a **Privilege** record to control user access to a specific rule, such as a flow or a flow action. When you add a privilege to a rule, users can access the rule only if they are assigned a role that has been granted the privilege.

**Attribute-based** access control allows you to control access to an object (case, report, property) by adding attribute values to objects, and configuring the access control policies. The access control policies determine whether specific users can access the objects. You can use one attribute to allow different actions in different objects. For example, you can assign the attribute Customer to a case to decide whether a user has permission to delete a case.

You can use three data types to represent an attribute: a **single string value**, a **list of string values**, and a **numerical value**. Also, hierarchical attributes represent a specified order of values. You can use either string type properties or numerical data types to define hierarchical attributes.

After configuring the attributes you configure the **Access Control Policy Condition** rule form, which defines a set of filters. Adding logic to these filters that combines the conditions means that users can do one of the actions defined in the access control policy if they meet the conditions.

After configuring the conditions, you configure the **Access Control Policy* rule form. By choosing one of the following actions, you limit what the user is allowed to do when accessing an object.

The options are:

* Read
* Update
* Discover
* Delete
* PropertyRead
* PropertyEncrypt

___

<a name="mashup"></a>
## Web Mashup

**Pega Web Mashup enables you to embed a Pega application in another web application. You can create a mashup to display information about a case.**

Common uses of a mashup are:

* Opening a new case.
* Displaying a user's worklist.
* Selecting and performing an assignment.

Anything that can be diaplyed in a harness is visible in a mashup.

Mashups consist of HTML code. The mashup itself is in wither an `iframe` or `div` tag, and represents a **Pega Gadget**. This is the view provided by the mashup.

___

<a name="activity"></a>
## Activities

Activities automate processing and are much like scripts. 

Best practices are:

* Keep activities short. Fewer than 25 steps.
* Use alternative rule types, such as data transforms, whenever possible.
* Limit hand-coded Java. Avoid Java steps in activities when standard methods are available.

Each step in an activity must specify a **method** that describes the action the system takes.

A **step page** is the page in memory on which the method is processed. For example, an activity called from a utility shape during case processing executes against the page assigned to the case type, *pyWorkPage*.

By default, an activity executes within the context in which it is called. You can change the context by specifying a page in the **step page** field. If you do this, you must also reference that page in the **Pages and Classes** tab of the activity form.

Entering `//` in the label field acts like a comment and skips execution for that step in the activity.

Activites can call other activities in two ways:

* **Call** - Pega runs the specified activity then returns control to the calling activity.

* **Branch** Pega runs the specified activity but returns control to the **rule** that called the first activity. The original activity ends when the branched activity is complete. For example, if activity A branches to B, control returns to the rule that called A when B finishes.

Activites can take parameters, which are stored on the **parameter** page on the clipboard, which is not visible in the clipboard tool. Use `param.<ParamName>` to reference a parameter.

___

<a name="background"></a>
## Background Processing

To configure a background task:

* Specify an activity to perform.
* Specify the class of an object either to queue or to schdule a job. This class must contain the activity that you want to run.
* Identify the nodes in the server cluster. By default this is a **BackgroundProcessing** node.
* Add an access group with access to your application to the **AsyncProcessor** requestor type. This allows Pega to identify and initialize a queue processor and job scheduler.

Tasks run weith eh **Queue Processor** can be queued using either the *Run in Background* smart shape, or the *Queue-For-Proccessing* method in an activity.

Tasks run using the queue processor can be run immediately or on a delay.

The **Job Scheduler** shcedules a recurring task. This can run at a specified interval, and the scheduler identifies the task to process at that time.

___

<a name="debug"></a>
## Debugging and Performance

Regular monitoring of log files during development and production helps ensure your application is operating properly. The **PegaRULES Log Analyzer (PLA)** is a standalone web application that developers and system administrators can use to view summaries of console logs.

Use the PLA to test new or reconfigured Pega applications during user acceptance testing (UAT), performance and stress testing, and immediately after deployment into a production environment. Testing reconfigured applications during UAT, during performance testing, and right after deployment is important because performance, stability, and scaling issues are most likely to occur during these times.

* The **Alert log** monitors performance issues such as events that exceed performance thresholds or failures.

* The **Pega log** monitors system stability, gathering system errors, exceptions, debug statements and other messages.

* The **JVM garbage collection log** displays memory usage.

To view events such as those that occur when a case processes, you use the **Tracer**. In Pega, the Tracer allows you to capture and view the events that occur during case processing. Unlike the Clipboard tool, which presents the current value of properties in memory, the Tracer presents a complete log of the events that occur during case processing. This allows you to identify the cause of execution errors, such as Java exceptions or incorrect property values.

Pega **Predictive Diagnostic Cloud (PDC)** is a Software as a Service (SaaS) tool that runs on Pega Cloud® and actively gathers, monitors, and analyzes real-time performance and health indicators from all active Pega Platform™ applications. PDC gathers, aggregates, and analyzes alerts, system health pulses, and guardrail violations generated from Pega applications to produce trending dashboards.

PDC allows you to monitor several on-premise and cloud-based Pega applications. Systems running on Pega Cloud are already integrated with PDC. Pega applications send data to PDC, PDC does not request data from Pega applications. Asynchronous communication ensures a small performance impact on the monitored Pega system.

A system **Key Performance Indicator (KPI)** is a measured value recorded by an alert. If the recorded value is higher than the KPI threshold configured in Pega Platform, the alert is triggered. Each alert maps to an action item type in PDC. When you elevate a KPI on an action item, all alerts with a lower KPI are ignored. Alerts with an equal or higher KPI are processed and assigned to an action item type. You can elevate the KPI on an action item in PDC.

___

<a name="relevant"></a>
## Relevant Records

Rules can be designated as **relevant records** to promote rule reuse. These rules can also be used in App Studio, with a more advanced configuration.

Records created in the **Data Designer** or **Case Designer** are automatically marked as relevant.

The following can be manually marked as relevant:

* Properties
* Sections
* Harnesses
* Paragraphs
* Correspondence
* Service Level Agreements
* Flows
* Flow Actions

There are three ways to designate a record as relevant:

* Creating the record in App Studio
* Marking the record from within the record itself
* Adding records from the **Relevant Records** tab the the **Application > Inventory** page.

Marking a relevant record as **inactive** makes it unavailable in **App Studio**.

___

<a name="migrate"></a>
## Application Migration

Applications are migrated between environments during development. From development, to testing, to production.

A **product rule** identifies the application components to be migrated. It lists the rulesets, data, and other objects that make up an application.

An application is packaged into an **application archive file**, a zip file containing XML documents.

There are two ways to create a product rule:

* Manually - provides more flexibility than the wizard, but potenitally time consuming and error prone.

* Using the **Application Packaging Wizard** - guides you through populating and creating a product rule using the existing rulesets in your applciation.



___

<a name="mobile"></a>
## Mobile Apps for Pega Applications

There are three prerequesites to deploying a mobile app using Pega:

* Uploading a certificate set for the appropriate platform (iOS, Android).
* Configuring access to the **Pega Mobile Build Server**.
* Confirming with the system admin that Pega is configured to support HTTPS.

The mobile UI is created on the **Channels and Interfaces** tab in App Studio.

The three main groups of tasks that are done when configuring an app are known as **Option Groups**:

* **Pega Mobile Client general options** - apply to any app built with the mobile channel, such as security and offline access.

* **OS-Specific build options** - impact how an app for a specific platform is built. Includes how debugging is configured.

* **App branding options** - control the look and feel of a mobile app.

**It is best practice to always use data pages as a data source. When offline, data pages store all completed work. These can be synced to the application server when the mobile device is online**.

<a name="offline"></a>
### Offline Processing for Mobile Apps

**Offline-enabled mobile apps allow for users to create cases and work on assignments while their devices are offline**.

Any offline work completed is saved to a queue. When the device is back online, data synchronization is triggered and the work uploaded to the server.

To enable offline functionality for a mobile app, two major tasks must be performed:

* Enable offline support for users by configuring the appropriate access groups.
* Enable the appropriate case types for offline processing.

**Before enabling a case type for offline use, it must be initialized with the default *pyStartCase* starting flow**.

Two key considerations when configuring a mobile app for offline use are:

* Considering which essential elements should be available offline.
* How to ensure that synch is fast and efficient.

A mobile app can access rules on the server only when it is online. Users need to access these mobile app rules to complete assignments. Data synchronization between the mobile app and Pega application supports rules access. You use whitelists and blacklists to identify and manage the rules specific to the mobile app.

* **Whitelist** - rules are synched between app and server.
* **Blackllist** - rules are not synched between app and server.

By default, a mobile app performs a full synchronization when users log in for the first time, and when an application developer forces a manual sync to push changes to mobile users. A full sync forces the mobile app to overwrite an entire rule or data record.

After an offline device comes back online, the mobile app performs a **delta synchronization**, or delta sync, with the server. A delta sync incrementally exchanges smaller amounts of data to reflect user activity, such as performing assignments or creating cases. Delta syncs improve the performance of the mobile app by reducing the data exchanged between the mobile app and the server.

Excluding large amounts of data that change infrequently can improve performance further on a delta synch.

___