FROM node:22-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies (use --production to avoid devDependencies)
RUN npm install --production

# Copy the rest of the application code
COPY . .

# Build your frontend application (if needed, e.g., for React or Angular)
RUN npm run build

# Expose the port your app runs on
EXPOSE 3000
