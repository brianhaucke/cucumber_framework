Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both Home and Offers page

Given User is on Greenkart Landing page
When user searched with short name "tom" and extracted actual name of product
Then user searched for same "tom" shortname in offers page
And validate product name in offers page matches with Landing Page

