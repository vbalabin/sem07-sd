import requests


class Cars:
    def get_cars(self):
        response = requests.get(url='http://localhost:8080/cars')
        print(response.text)

    def get_car(self, _id):
        response = requests.get(url=f'http://localhost:8080/cars/{_id}')
        print(response.text)

    def create_car(self, model, color, number, user):
        body = {
            "model": model,
            "color": color,
            "number": number,
            "user": user
        }
        response = requests.post(url='http://localhost:8080/cars', json=body)
        print(response.text)

    def delete_car(self, _id):
        response = requests.delete(url=f'http://localhost:8080/cars/{_id}')
        print(response.text)

    def update_car(self, what_id, to_car):
        body = to_car
        response = requests.put(url=f'http://localhost:8080/roles/{what_id}', json=body)
        print(response.text)


if __name__ == '__main__':
    roles = Cars()
    roles.create_car('Hyundai', 'white', 'A255AA', {
        "id":"d488626b-ebce-494d-a419-9d07f134cdd6",
        "firstname":"John",
        "lastname":"Doe",
        "role":{"name":"USER"}
        }
    )
    roles.get_cars()
