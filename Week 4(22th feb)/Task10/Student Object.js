let student = {
    name: "John Doe",
    age: 20,
    major: "Computer Science",
    greet: function() {
        return `Hello, my name is ${this.name}.`;
    },
    address: {
        city: "New York",
        state: "NY",
        getFullAddress: function() {
            return `${this.city}, ${this.state}`;
        },
        updateCity: function(newCity) {
            this.city = newCity;
        }
    },
    updateMajor: function(newMajor) {
        this.major = newMajor;
    }
};
console.log(student.name); 
console.log(student.age); 
console.log(student.major); 
console.log(student.greet()); 
console.log(student.address.getFullAddress()); 
student.address.updateCity("Los Angeles");
student.updateMajor("Software Engineering");
delete student.age;
delete student.updateMajor;
console.log(student);
