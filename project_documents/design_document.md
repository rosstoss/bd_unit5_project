# [team name] Design Document

## _OEMContextuals_ Design

## 1. Problem Statement

OEMContextuals is a website dedicated to providing end users access to high quality OE/OEM car parts, regardless of make and model, that are
competitvely priced with other services on the web that sometimes offer the same service at a premium.

This service will provide a user with clearly laid out website functionality
to help them find exactly what they need with the least drama possible.
It will be set up as an information catalog with all its corresponding parts, including
abilities for users to input filtering for which car they need help with and clearly laid out information
with the ability for users to send suggestions on how to better the website and keep info current.

Thus far, we aim to service a limited scope of cars and expand accordingly.

## 2. Top Questions to Resolve in Review

1.  What should the scope of information provided look like for products offered
2.  Need to iron down how the search function will work on the site, so far using VINs or just make/model
3.  Figure out how big of scope to cover so far as car support

## 3. Use Cases

U1. \*As a user, I want to easily find parts and information for my car when I search the website with my make/model or VIN

U2. \*As a user, I want to be able to find resources for my car using the VIN or year, make, and model

U3. \*As a user, I want to be able to add suggestions to website and post information to forums

## 4. Project Scope

We intend to give user access to specific data about their car and provide a way for them to discuss and ask questions
to other users.

### 4.1. In Scope

_Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?_

- Create a search function that works with a broad range of cars
- Implement information about cars
- Create forum-like service that allows communication with other users

### 4.2. Out of Scope

- It doesn't make sense to rollout the website with an absurd amount information for
  every car brand, but rather want to focus on a few brands (1 - 5) going back 20 years

# 5. Proposed Architecture Overview

- The initial website will provide a basis of how the future website will look like,
  offering the ability to find parts and information for the car you are looking for
  and providing a simple and seamless design that works well and repeatedly.

# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your
_`-Model`_ package. These will be equivalent to the _`PlaylistModel`_ and
_`SongModel`_ from the Unit 3 project._

```

// CarPlatformModel

String vin;
String year;
String make;
String model;
String trim;
Integer mileage;

```

```

// CustomerSuggestions

String name;
String email;
String suggestion;

```

## 6.2. Get Car Platform Information Endpoint

_Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)_

_(You should have a separate section for each of the endpoints you are expecting
to build...)_

- Accepts GET requests to /carPlatformModel/:vin
- Accepts a VIN and returns the corresponding vehicle information \* If VIN breakdown does not match any vehicles in database, will throw a
  'VehicleNotFoundException'

## 6.3 Forum Endpoint

_(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)_

- Accepts POST request to /userForums
- Accepts data to be posted to message boards

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the _`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

- CarPlatformTable
  First part of VIN would be the partition key, which is brand specific
  Sort key would be the rest of the VIN, identifying trim, year, etc.

# 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)_
