# Fix Thymeleaf Dashboard Template Error

## Steps:
1. [ ] Update HomeController.java: Change dashboard() return \"dashboard\" to \"view/dashboard\"
2. [ ] Create header.html and footer.html in templates/view/includes/
3. [ ] Fix includes in dashboard.html with th:replace th:fragment=\"*\" 
4. [ ] Restart Spring Boot app (`mvn spring-boot:run` or IDE)
5. [ ] Test http://localhost:8080/dashboard

Current: Step 1
