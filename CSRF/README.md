# AppacheNIFI - CSRF Token

This flowfile show how to use [CSRF Token](https://en.wikipedia.org/wiki/Cross-site_request_forgery) authentication,
using cache services, for the purpose of reducing the number of authentication requests.

## Short description of the flow

1. Prepare the flowfile.
2. Fetch token from cache.
3. If no token found or token is invalid (Step 6) generate new token and store it in cache.
4. Fetch token from cache (After generated)
5. Update flowfile with the token and some cookies.
6. Send flowfile - in case of authenticaion failre, genereate new token (Step 3).

![flow](https://raw.githubusercontent.com/idanshemesh/AppacheNIFI/master/CSRF/CSRF_Flow.png)

Enjoy :smiley:
