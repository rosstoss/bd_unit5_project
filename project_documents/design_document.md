# [team name] Design Document

## _OEMContextuals_ Design

## 1. Problem Statement

RossByte is a personal website that will serve as a portfolio of myself. It will contain a homepage introducing
myself, an about section, project gallery, contact form, and an admin panel to more simply update information like
projects, skills, and other information.

This website will help to inform users of what I've done and what I can do.

## 2. Top Questions to Resolve in Review

1.  What should admin panel look like and function/possibly implement other features
2.  How exactly should contact form work
3.  How should homepage function

## 3. Use Cases

U1. \*As a user, I want to be able to easily navigate through the website logically and concisely

U2. \*As a user, I want to be able to submit a contact request

U3. \*As an admin, I want to be able to easily update the information on the website using a CRUD system

## 4. Project Scope

I intend to give the user clear, laid out access to the website that is easy to navigate.

### 4.1. In Scope

_Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?_

- Be able to provide users with a way to find out about Ryker

### 4.2. Out of Scope

- Don't feel like there is too much to go out of scope on because of it's simplicity

# 5. Proposed Architecture Overview

- The homepage will be clear and concise with different links to other pages on the website represented by boxes on 
the webpage.

# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your
_`-Model`_ package. These will be equivalent to the _`PlaylistModel`_ and
_`SongModel`_ from the Unit 3 project._

```

// aboutModel

String background
StringList skills
StringList interests

```

```

// projectsModel

StringList projects;

```

## 6.2. Get Projects Endpoint

- Accepts GET requests from /projects
- Can request all projects or a single project based upon an id assigned to that project using /projects/:id

## 6.3 Post New Project Endpoint

- Accepts POST request to /projects
- Adds new project to website portfolio, which could include project name, description,
technologies used, and images that correspond to project

## 6.4 Submit Contact Form Endpoint

- Accepts POST requests to /contact
- Used to send messages by a contact form, including visitor's name, email, and message

# 7. Tables

- ProjectTable

  - Stores information of projects using an: id, name, description, technologies used, link to project, 
image url, when it was created, and if/when it was updated

- SkillsTable

  - Stores information about skills using an: id, skill name, proficiency level (ex. beginner to advanced), when it 
was created, and when/if it was updated

- ContactMessagesTable

  - Stores messages sent through contact form using an: id, name of sender, email of sender, message content, and 
message timestamp

# 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)_
