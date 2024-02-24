# product_catalo_backend

server port: 8118
neo4j db community version 	5.15.0.

Swagger: http://host:8118/swagger-ui/index.html#/

endpoind characteristics:

User creditionals are given as parametr to get token:
http://host:8118/get-token?login=***&password=***


Incoming parametrs for each API:

  - authToken (required)(String)
  - offset (not required)(integer) by default = 0
  - limit (not required)(int) by default = 20
  - details (not required)(int)(input value 1 or 0): 1 (full informaions with relationships inclueded) or 0 (only node without relationships) by defaut = 0
  - fields(String Array) takes as string, exampe: id,name,price,type by default = all fields
