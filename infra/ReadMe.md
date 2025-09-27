-- Vm args to customize image name and enabling publish image property for spring boot image plugin
spring-boot:build-image spring-boot:build-image -Dspring-boot.build-image.imageName=thecodealchemist/hello-k8s-app:0.0.1 -Dspring-boot.build-image.publish=true -f pom.xml

-- to run a docker container
docker run --rm -p 8080:8080 thecodealchemist/hello-k8s-app:0.0.1

-- setting variable
$NS = "hellok8s-app-ns"

-- setting variable
$INFRA_DIR = "C:\Users\vimau\Downloads\hello-k8s-app\infra"

-- applying namespace yml to create a new namespace
kubectl apply -f $INFRA_DIR/00-namespace.yml

-- applying app yml to deploy a new app with service
kubectl apply -f $INFRA_DIR/01-app.yml

-- to check the status of app deployment
kubectl -n $NS rollout status deployment/hellok8s-app --timeout=120s

-- to forward the 8080 port when using ClusterIP service
kubectl -n $NS port-forward svc/hellok8s-app 8080:8080
