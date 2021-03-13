#### **Marvel Characters Consumer Application**

This application consumes freely available (after registering yourself at [marvel developer 
portal](https://developer.marvel.com/)) marvel comics characters api's. 
Complete documentation is present [here](https://developer.marvel.com/documentation/getting_started)

Here is a little gist of steps needs to be taken to get hands dirty -
1. Get yourself the API Key [here](https://www.marvel.com/signin?referer=https%3A%2F%2Fdeveloper.marvel.com%2Faccount)
   Keep the public and private keys handy with you. You will need them both for this project to work.
2. Public Key will be used as `apikey` while calling the api's from clients.
3. All the API definitions can be read and tested [here](https://developer.marvel.com/docs)

**To access `GET` /characters from client, you will require below-**
1. URL: `https://gateway.marvel.com:443/v1/public/characters`
2. ApiKey (Public Key obtained already, if you are following along), Ex - 214234jahslkdjfhs23123w

Final URL would look like : `https://gateway.marvel.com:443/v1/public/characters?apikey=214234jahslkdjfhs23123w`

**To access the `GET` /characters from client from server/application, you will-**
1. need URL as usual : `https://gateway.marvel.com:443/v1/public/characters`
2. timestamp in string : `1231231`
3. public key
4. MD5 hash of (timestamp+public key+private key)

Final Url will look something like this - `https://gateway.marvel.com:443/v1/public/characters?ts=1232&apikey=214234jahslkdjfhs23123w&hash=sdfds3253sfsadf32`

**Query Parameters**
 
Different Query Parameters can be added in the url, refer [this](https://developer.marvel.com/docs#!/public/getCreatorCollection_get_0) for usage
Example - `https://gateway.marvel.com:443/v1/public/characters?ts=1232&apikey=214234jahslkdjfhs23123w&hash=sdfds3253sfsadf32&limit=20&offset=10`
Above url will fetch the 20 (`limit`) characters starting from 10th (`offset`) character from `GET` /characters Api

