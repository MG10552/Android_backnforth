# Android_backnforth
Pair of Android apps preseting the way of back and forth communication and information sharing.


Zadanie polega na stworzeniu dwóch aplikacji. Pierwsza z nich ma na celu umożliwienie użytkownikowi wpisania pewnej wiadomości i po wciśnięciu guzika rozgłoszenia intencji z jej treścią. Druga natomiast ma zawierać usługę wraz z Broadcast Receiverem, za pomocą którego możliwe będzie przechwycenie rozgłoszonej intencji. Następnie z przechwyconej w ten sposób intencji należy wydostać wiadomość wpisaną przez użytkownika i stworzyć notyfikację, która wyświetli ją na pasku notyfikacji.


Wymagania:

1) Skorzystanie z Activity oraz Intent do wpisywania wiadomości, dalszego jej przesyłu. (Aplikacja 1)


2) Należy dodać elementy GUI (Button, TextField lub AlertDialog). (Aplikacja 1)


3) Należy stworzyć Service z Broadcast Receiver, który wyłapie rozgłoszoną intencję i stworzy oraz wyświetli notyfikację zawierającą treść wpisaną w pierwszej aplikacji (za pomocą Notification Manager) i po kliknięciu na nią uruchamiać dowolne Activity (np. to z Aplikacji 1). Dodatkowo Broadcast Receiver powinien mieć uprawnienia do odbioru tych intencji. (Aplikacja 2)


Łączna liczba punktów do uzyskania: 10
