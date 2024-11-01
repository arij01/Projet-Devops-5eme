# Stage 1: Build the Angular app
FROM node:22-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies (use --production to avoid devDependencies)
RUN npm install --production

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Copy the rest of the application code
COPY . .

# Build the Angular app for production
RUN npm run build --prod

# Stage 2: Serve the Angular app with NGINX
FROM nginx:alpine

# Copy the built application from the builder stage to nginx's html directory
COPY --from=builder /app/dist/frontend /usr/share/nginx/html

# Expose the port that NGINX will listen on (default is 80)
EXPOSE 80

# Start NGINX server
CMD ["nginx", "-g", "daemon off;"]
