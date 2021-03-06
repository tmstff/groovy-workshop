class User {
    def firstName
    def lastName

    @Override
    boolean equals(Object obj) {
        return firstName == obj.firstName && lastName == obj.lastName
    }

    @Override
    String toString() {
        return "User $firstName $lastName"
    }
}

trait Aging {

    def age=0

    def birthdayParty() {
        age = age + 1
    }
}

def newUser(values = [:]) {
    def defaultValues = [
            firstName: "Tim",
            lastName: "Steffens"
    ]
    new User(defaultValues + values) as Aging
}

def u = newUser(firstName: "Arnold", lastName: "Schwarzenegger")
u.firstName + " " + u.lastName

u.birthdayParty()
u.age

