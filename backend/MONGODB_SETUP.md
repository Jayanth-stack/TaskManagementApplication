# MongoDB Setup Instructions

## 1. Install MongoDB

### Windows
1. Download MongoDB Community Server from [MongoDB Download Center](https://www.mongodb.com/try/download/community)
2. Run the installer and follow the instructions
3. Choose "Complete" installation
4. Install MongoDB Compass (GUI tool) when prompted

### macOS
```bash
brew tap mongodb/brew
brew install mongodb-community
```

### Linux (Ubuntu)
```bash
sudo apt-get update
sudo apt-get install -y mongodb
```

## 2. Start MongoDB Service

### Windows
MongoDB should run as a service automatically after installation.

### macOS
```bash
brew services start mongodb-community
```

### Linux
```bash
sudo systemctl start mongodb
```

## 3. Database Setup

1. Open MongoDB Compass
2. Connect to your local MongoDB instance (usually at `mongodb://localhost:27017`)
3. Create a new database named `taskmanagement`
4. MongoDB will automatically create collections when data is first inserted

## 4. Initial Data

The application will automatically create the following collections:
- `users`
- `roles`
- `programs`
- `tasks`

## 5. Role Data Initialization

On first startup, the application will initialize the required roles:
- `ROLE_USER`
- `ROLE_ADMIN`

## 6. Using the MongoDB Shell

To access the MongoDB shell:

```bash
mongosh
```

Basic commands:
```javascript
// Show databases
show dbs

// Select database
use taskmanagement

// Show collections
show collections

// Query data
db.users.find()
db.tasks.find().pretty()
```

## 7. Troubleshooting

If you encounter connection issues:
1. Verify MongoDB is running: `mongosh`
2. Check MongoDB logs
3. Ensure application properties are correctly configured in `application.properties` 