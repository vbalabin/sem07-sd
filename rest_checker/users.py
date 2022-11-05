import requests


class Users:
    def get_users(self):
        response = requests.get(url='http://localhost:8080/users')
        print(response.text)

    def get_user(self, _id):
        response = requests.get(url=f'http://localhost:8080/users/{_id}')
        print(response.text)

    def create_user(self, firstname, lastname, rolename):
        body = {
            "firstname": firstname,
            "lastname": lastname,
            "role": {"name": rolename}
        }
        response = requests.post(url='http://localhost:8080/users', json=body)
        print(response.text)

    def delete_user(self, _id):
        response = requests.delete(url=f'http://localhost:8080/users/{_id}')
        print(response.text)

    def update_user(self, what_id, to_user):
        body = to_user
        response = requests.put(url=f'http://localhost:8080/users/{what_id}', json=body)
        print(response.text)


if __name__ == '__main__':
    roles = Users()
    roles.get_users()
    roles.create_user('John', 'Doe', 'USER')
