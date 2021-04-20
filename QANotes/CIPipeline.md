# CI Pipeline 

***Example notes to demonstrate the thought process for choosing the tech to use for a CI pipeline to support a small project.***

---

## Live Environment 

### Options 

- Hosted on local machines. 

- Hosted using Cloud Provider. 

## Local Server 

### Advantages 

- All web testing can be done on a local machine. 

- Streamlines testing by bypassing the need to upload to a remote server, test, make changes, re-upload, re-test etc. 

- Testing not affected by internet outages. 

- No extra costs associated with hosting the site. 

- Browser extensions can be easily tested from a local machine. 

- Testing locally doesn’t compromise the security of a live site. 

### Disadvantages 

- Analytics and load times may not be accurate. Load times are always faster from your machine than from a remote machine. 

- Uses server-side languages which need their own tools to interpret and run code. 

- Local environment could be different from the Production Environment. Your machine’s OS, software, specs etc. are different from users’ configuration. 

### Options for Local Server

- XAMPP – Windows, Linux, Mac OS X 

- MAMP – Mac OS X 

- Python with SimpleHTTPServer module 

- SeleniumHQ for java, Python, JavaScript, C#, Ruby 

- Node.JS for JavaScript 

- Django for python 

- Flask for python 

- PHP’s development server for PHP 

- StoryPlayer for PHP 
 
## Cloud Hosting 

### Advantages 

- **Scalability**. In the short term, you can deal with a surge of internet traffic. In the long term, you can scale up your infrastructure as your company grows. 

- Servers can be load balanced for more efficient use of existing servers. 

- Disaster recovery is easier. 

### Disadvantages 

- **Security**. Sensitive data is sometimes stored on the cloud, and is often targeted by hackers. Data breaches are often made public and each one loses the trust of more customers. 

- Downtime is possible, internet outages prevent testing and hosting of your website. 

- **Accessibility**. You need internet access to access the data on your website. 

- **Cost**. Hosting service has to be paid for, can be £10 m/o, can be £100 m/o. 

## Chosen Option 

Hosting the website locally, using python with SimpleHTTPServer to test. If the code included server-side languages, use Django for python, Node.JS for JavaScript, PHP’s dev server for PHP. 

## Email Server 

### Options 

- Default email notifier in Jenkins, just sends a default email with build number and status. 

- Jenkins email extension plugin, allows for more customisation. When an email is sent, to who, contents of email. 

- GitLab with SendMail. Custom email content, send to users of a chosen group or project. 

- GitLab with Slack. Slack not as widely supported as email, but useful if already set up in the dev team. 

- TeamCity’s SMTP. 

- Bamboo SMTP. 

- Amazon Simple Email Service (SES). Send mail with either SMTP or Amazon’s API. Integration with Amazon services, none of which we’re using here. 

### Chosen Option 

Jenkin’s email extension plugin, as we’re using Jenkins as the automated testing tool it makes sense for us to use its integrated email server. We’re using this over the default as it allows for customisation of email contents, recipients etc.  