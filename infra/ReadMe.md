docker run --rm -p 8080:8080 thecodealchemist/hello-k8s-app:0.0.1

$NS = "hellok8s-app-ns"

$INFRA_DIR = "C:\Users\vimau\Downloads\hello-k8s-app\infra"

kubectl apply -f $INFRA_DIR/00-namespace.yml

kubectl apply -f $INFRA_DIR/01-app.yml

kubectl -n $NS rollout status deployment/hellok8s-app --timeout=120s

kubectl -n $NS port-forward svc/hellok8s-app 8080:8080