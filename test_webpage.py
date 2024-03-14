from selenium import webdriver

# Set the path to chromedriver if not in PATH
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument("--headless")  # Run headless if needed
driver = webdriver.Chrome(options=chrome_options)

# Open the local HTML file
driver.get("file:///home/devops/Downloads/ui.vision.html")

# Perform actions on the HTML page as needed
# For example, interact with elements, assert values, etc.

driver.quit()
