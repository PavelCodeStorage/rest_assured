@1
Feature: ApiVerification
  As a developer
  I want to be able to sure that api works fine
  in order to be sure my feature is implemented properly

@api @projectId
Scenario: User can verify projectID
And User sent request with POST method and body.json file
Then Response is appeared with projectId 2240277532

@api @error
Scenario: User can verify response error
And User once again sent request with POST method and body.json file
Then Response error Sync item already processed. Ignored is appeared

@api @projectId
Scenario: User can verify full response
 And User sent request with POST method and body.json file
 Then Response is appeared