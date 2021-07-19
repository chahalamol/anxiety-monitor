# Anxiety Monitor

#### A desktop app to monitor anxiety levels

This application uses a standardized **Generalized Anxiety Disorder** (GAD-7) score system to monitor a user's anxiety
levels. Users who have been diagnosed with generalized anxiety disorder will be able to measure and record their
anxiety scores over time. This app is mainly geared towards users who are currently taking anti-anxiety medications
and would like to monitor how well their medication is working overtime. However, anyone who would like to monitor their
anxiety levels throughout a certain period of time can use this app. The GAD score uses a set of standardized questions 
which users rate on a scale of 0 - 3. Based on their score, they receive a severity score, which then gets stored in the 
system. They can access a record of their scores overtime and analyze how they are doing.

### How It Works
* Answer a few questions based on a standardized questions
* Get an instant severity score and classification
* Analyze anxiety levels overtime

## User Stories
Feb 10, 2021
* As a user, I want to be able to answer a question.
* As a user, I want to be able to receive a score based on my reply.
* As a user, I want to be able to view my previous score.
* As a user, I want to be able to obtain a classification result.

## User Stories
Feb 25, 2021
* As a user, I want to be able to take the GAD questionnaire.
* As a user, I want to be able to save my previous scores to a file.
* As a user, I want to be able to load my previous scores from a file.

## User Stores
March 12, 2021
* AS a user, I want to be able to open graphical user interface.
* As a user, I want to be able to start an assessment.
* As a user, I want to be able to answer a question.
* As a user, I want to be able to get a classification result.

## Phase 4: Task 2
Handling exceptions
* setSeverity() method throws ScoreTooHighException if the user score is too high

## Phase 4: Task 3
See attached UML Diagram

One way to potentially refactor the code would be to use more abstract classes
to get rid of the repititve code for JSwing libary code as there are so many
JSwing components that are being used right now in the code.