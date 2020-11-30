import 'package:flutter/material.dart';

void main() {
    runApp(MyApp());
}

class MyApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            initialRoute: '/',
            routes: {
                '/': (context) => FirstScreen(),
                '/second': (context) => SecondScreen(),
            },
        );
    }
}

class FirstScreen extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return Scaffold(
            appBar: AppBar(title: Text('First Screen')),
            body: Center(
                child: ElevatedButton(
                    child: Text('Next'),
                    onPressed: () {
                        Navigator.pushNamed(context, '/second');
                    },
                ),
            ),
        );
    }
}

class PersonalData {
    String name;

    PersonalData(name) {
        this.name = name;
    }
}

class SecondScreen extends StatelessWidget {
    final items = List<String>.generate(6, (i) => new PersonalData(['Liam', 'Noah', 'Ava', 'Sophia', 'Elijah', 'James][i]).name);

    @override
    Widget build(BuildContext context) {
        return new Scaffold(
            appBar: AppBar(
                title: Text('Second Screen'),
            ),
            body: ListView.builder(
                itemCount: (6 <= items.length) ? items.length + 1 : items.length,
                itemBuilder: (context, index) {
                    return (index == items.length)
                        ? Container(
                            child: ElevatedButton(
                                child: Text('Back'),
                                onPressed: () {
                                    Navigator.pop(context);
                                },
                            ),
                        )
                        : ListTile(
                            title: Text('${items[index]}'),
                        );
                },
            ),
        );
    }
}
