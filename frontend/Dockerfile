FROM node:22-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies (use --production to avoid devDependencies)
RUN npm install --production

# Copy the rest of the application code
COPY . .

RUN npm run build --prod

# Stage 2: Serve the Angular app with NGINX
FROM nginx:alpine

# Copy the built application from the builder stage to nginx's html directory
COPY --from=builder /app/dist/frontend /usr/share/nginx/html

# Expose the port your app runs on
EXPOSE 80
# Start NGINX server
CMD ["nginx", "-g", "daemon off;"]
