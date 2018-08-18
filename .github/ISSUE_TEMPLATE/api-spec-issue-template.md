---
name: API Spec issue template
about: Define API specifications

---

# `<Issue Title>`

## Request
- URI: 
- HTTP Method: 
- Header

| Name | Value | Description |
|:-----|:-----|:------------|
| | | |

- parameter

| Name | Type | Description |
|:-----|:-----|:------------|
| | | |


- example
```
FIXME: fill response data
```

---

<br>

## Response

### Success
- Status: 
- Header

| Name | Value | Description |
|:-----|:-----|:------------|
| | | |

```
FIXME: fill response data
```

<br>

### Fail

| Status | Description |
|:-------|:------------|
| | |

#### `<Status>`
```
FIXME: fill response data
```

---

<br>

> FIXME: Remove below example content
# Example

# User's issue list query API

## Request
- URI: /user/issues
- HTTP Method: GET
- Header

| Name | Value | Description |
|:-----|:------|:------------|
| Accept | application/json | Accept contents |

- parameter

| Name | Type | Description |
|:-----|:-----|:------------|
| sort | string | What to sort results by. <br> Can be either `created`, `updated`, `comments`. <br> Default: `created` |
| filter| string | Indicates which sorts of issues to return. <br> Can be one of: <br> `assigned`: Issues assigned to you <br> `created`: Issues created by you <br> `mentioned`: Issues mentioning you <br> `subscribed`: Issues you're subscribed to updates for <br> `all`: All issues the authenticated user can see, regardless of participation or creation <br> Default: `assigned` |
---

<br>

## Response

### Success
- Status: 200 OK
- Header

| Name | Value | Description |
|:-----|:------|:------------|
| Content-Type | application/json | describe the data contained in the body fully enough that the receiving user agent can pick an appropriate mechanism |

```json
Status: 200 OK
Content-Type: application/json
Link: <https://api.github.com/resource?page=2>; rel="next",
      <https://api.github.com/resource?page=5>; rel="last"

[
  {
    "id": 1,
    "node_id": "MDU6SXNzdWUx",
    "url": "https://api.github.com/repos/octocat/Hello-World/issues/1347",
    "repository_url": "https://api.github.com/repos/octocat/Hello-World"
    ...
  }
]
```

<br>

### Fail

| Status | Description |
|:-------|:------------|
| 400 Bad Request | invalid parameter |
| 404 Not Found | not found data |
| 500 Internal Server Error | unknow server error |

### 400 Bad Request
```json
Status: 400 Bad Request
Content-Type: application/json

{
    "code": 400,
    "message": "Please input the username"
}
```

### 404 Not Found
```json
Status: 404 Not Found
Content-Type: application/json

{
    "code": 404,
    "message": "not found"
}
```

### 500 Internal Server Error
```json
Status: 500 Internal Server Error
Content-Type: application/json

{
    "code": 500,
    "message": "unknow error"
}
```
