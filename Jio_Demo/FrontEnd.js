const axios = require('axios');

const viewUsers = () => {axios.get('http://localhost:8080/user/all').then(resp => {
    console.log(resp.data);
});};

const viewSingleUser = () =>{axios.get("http://localhost:8080/user/find/4").then(resp =>{
  console.log(resp.data);

});};

const addUser = () =>{axios.post("http://localhost:8080/user/add", {
    firstName: 'Bob',
    lastname: 'Dylan',
    phoneNumber: '+446909624800',
    email:'bobdylan@esketit.com'
  })
.then(function (response) {
    console.log(response);
  })
.catch(function (error) {
    console.log(error);
  });}

const updateUser = () =>{axios.put("http://localhost:8080/user/update/6", {
      firstName: 'Bobby',
      lastname: 'Dylan',
      phoneNumber: '+446909624800',
      email:'bobbyboy420@esketit.com'

    })
.then(function (response) {
      console.log(response);
    })
.catch(function (error) {
      console.log(error);
    });}

const deleteUser = () => {axios.delete('http://localhost:8080/user/delete/6').then(resp => {
        console.log("User deleted");
});};



//Functions below for CRUD application
      //viewUsers();
     //viewSingleUser();
     //addUser();
    //updateUser();
    //deleteUser();
