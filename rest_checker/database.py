# pip install psycopg2-binary
import psycopg2

query = '''

'''


class PSCursor:
    def __init__(self, options = None) -> None:
        if options is None:
            options = {
                "host": "localhost",
                "database": "spring_lab_db",
                "user": "ivt93",
                "password": "ivt93",
                "port": "5432"
            }
        self._conn = psycopg2.connect(**options)

    def __enter__(self):
        try:
            self._cur = self._conn.cursor()
        except Exception as e:
            self._conn.close()
            raise e.__class__('Something went wrong')
        return self._cur

    def __exit__(self, *args):
        self._conn.commit()
        self._cur.close()
        self._conn.close()


if __name__ == '__main__':
    
    with PSCursor() as cur:
        cur.execute(query)
