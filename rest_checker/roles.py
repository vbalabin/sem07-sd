import requests


class Roles:
    def get_roles(self):
        response = requests.get(url='http://localhost:8080/roles')
        print(response.text)

    def get_role(self, name):
        response = requests.get(url=f'http://localhost:8080/roles/{name}')
        print(response.text)

    def create_role(self, name):
        body = {
            "name": name
        }
        response = requests.post(url='http://localhost:8080/roles', json=body)
        print(response.text)

    def delete_role(self, name):
        response = requests.delete(url=f'http://localhost:8080/roles/{name}')
        print(response.text)

    def update_role(self, what_name, to_name):
        body = {
            "name": to_name
        }
        response = requests.put(url=f'http://localhost:8080/roles/{what_name}', json=body)
        print(response.text)


if __name__ == '__main__':
    roles = Roles()
    roles.get_roles()
    # roles.update_role('user1', 'USER')
