podman run --rm --name mongo --user mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -e MONGO_INITDB_DATABASE=cart -v /tmp/mongodb/data:/opt/mongo/db mongo:latest

# Populate collection
# db.customers.insertMany([ {name: "user1", email: "user1@teste.com", registrationDate: new ISODate("2022-05-22T14:10:30Z")}, {name: "user2", email: "user2@teste.com", registrationDate: new ISODate("2020-05-18T14:10:30Z")}, {name: "user3", email: "user3@teste.com", registrationDate: new ISODate("2020-02-18T01:10:30Z")} ])