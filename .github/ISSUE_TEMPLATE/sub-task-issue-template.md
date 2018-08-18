---
name: Sub Task issue template
about: Describe the Sub Task related to User Story or Task

---

# `<Issue Title>`

> FIXME: Describe the task in free format
* `<something task description>`

## 완료 조건
> FIXME: Describe the completion condition
- [ ] `<completion condition>`

<br> 

## relate to issue
> FIXME: Describe relate to issue
* `<issue title> <#issue number>`

<br>

> #### Reference
> FIXME: fill reference link
> * `[title](link)`

---

<br>

> FIXME: Remove below example content
# Example

# Github를 위한 Slack webhook 설정
* 주요 branch(master, release, develop)에 대한 PR이 생성되면 review들이 slack을 통해 인지할 수 있도록 Slack webhook을 설정한다
  * direct merge는 불가하기 때문에 push가 아닌 PR에 대해서만 설정

### 완료 조건
- [ ] PR 생성시 slack channel로 noti가 온다

<br> 

## relate to issue
* issue tracking을 통해 프로젝트를 진행하기 #15

<br>

> #### Reference
> [Incoming Webhooks - Slack](https://api.slack.com/incoming-webhooks)
